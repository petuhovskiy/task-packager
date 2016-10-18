package com.petukhovsky.tpack.task.build;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.commons.compiler.CompilationResult;
import com.petukhovsky.jvaluer.commons.exe.Executable;
import com.petukhovsky.jvaluer.commons.gen.Generator;
import com.petukhovsky.jvaluer.commons.lang.Language;
import com.petukhovsky.jvaluer.commons.local.OSRelatedValue;
import com.petukhovsky.jvaluer.commons.run.RunInOut;
import com.petukhovsky.jvaluer.commons.source.Source;
import com.petukhovsky.jvaluer.gen.RunnableGenerator;
import com.petukhovsky.jvaluer.impl.BuiltinImpl;
import com.petukhovsky.jvaluer.util.FilesUtils;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.exception.*;
import com.petukhovsky.tpack.model.core.SourceModel;
import com.petukhovsky.tpack.model.core.TaskModel;
import com.petukhovsky.tpack.model.exe.CompiledModel;
import com.petukhovsky.tpack.model.exe.ExecutableModel;
import com.petukhovsky.tpack.model.exe.NativeModel;
import com.petukhovsky.tpack.model.gen.GeneratorModel;
import com.petukhovsky.tpack.task.core.Task;
import com.petukhovsky.tpack.template.TemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by arthur on 12.10.16.
 */
public class BuilderImpl implements TaskBuilder {

    private final static String EXE_EXT = new OSRelatedValue<String>().windows(".exe").orElse(".out");

    private final JValuer jValuer;
    private final TemplateEngine templateEngine;

    public BuilderImpl(JValuer jValuer, TemplateEngine templateEngine) {
        this.jValuer = jValuer;
        this.templateEngine = templateEngine;
    }

    @Override
    public Task build(TaskModel model, ResourceReader reader, Path storage) {
        Path sourcesDir = storage.resolve("sources");
        Path executablesDir = storage.resolve("executables");
        Path testsDir = storage.resolve("tests");

        if (!FilesUtils.assureEmptyDir(sourcesDir) || !FilesUtils.assureEmptyDir(executablesDir) || !FilesUtils.assureEmptyDir(testsDir)) {
            throw new TPackBuildException("can't create directories");
        }

        Map<String, Source> sources = new HashMap<>();
        Map<String, Executable> executables = new HashMap<>();
        Map<String, Generator> generators = new HashMap<>();

        for (SourceModel source : model.getSources()) {
            String id = source.getId();
            if (id == null) throw new TPackBuildException("Source id is null");
            if (sources.containsKey(id)) throw new DuplicateIdException("Source id [" + id + "] is duplicate");

            Language language = source.getLang() == null
                    ? jValuer.getLanguages().findByPath(Paths.get(source.getPath()))
                    : jValuer.getLanguages().findByName(source.getLang());

            if (language == null) throw new UnknownLanguageException("Language " + source.getLang() + " not found");

            Path path = sourcesDir.resolve(id + "." + Optional.ofNullable(getExtension(source.getPath())).orElse("source"));
            try (InputStream is = reader.openInputStream(source.getPath())){
                if (is == null) throw new TPackException(String.format("Source[%s] not found", source.getPath()));
                Files.copy(is, path);
            } catch (IOException e) {
                throw new TPackBuildException("Can't copy source", e);
            }
            sources.put(id, new Source(path, language));
        }

        for (ExecutableModel executable : model.getExecutables()) {
            if (executable instanceof CompiledModel) {
                CompiledModel compiledModel = (CompiledModel) executable;

                String id = compiledModel.getId();

                if (id == null) throw new TPackBuildException("Executable id is null");
                if (executables.containsKey(id)) throw new DuplicateIdException("Executable id [" + id + "] is duplicate");

                String sourceId = compiledModel.getSourceId();

                Source source = sources.get(sourceId);
                if (source == null) throw new IdNotFoundException(
                        String.format("Source [id=%s] not found(executable=%s)", sourceId, id));

                CompilationResult compilation = jValuer.compile(source);
                if (!compilation.isSuccess()) {
                    throw new CompilationFailedException(
                            String.format("can't compile source [id=%s]%nLog:%n%s", sourceId, compilation.getComment()));
                }

                Path path = executablesDir.resolve(id + "." +
                        Optional.ofNullable(getExtension(compilation.getExe().toString()))
                                .orElse(EXE_EXT));

                try {
                    Files.copy(compilation.getExe(), path);
                } catch (IOException e) {
                    throw new TPackBuildException("Can't copy executable", e);
                }

                executables.put(id, source.getLanguage().createExecutable(path));

            } else if (executable instanceof NativeModel) {
                throw new UnsupportedOperationException("not supported");
            } else {
                throw new UnsupportedOperationException("not supported");
            }
        }

        for (GeneratorModel generator : model.getGenerators()) {
            String id = generator.getId();

            if (id == null) throw new TPackBuildException("Generator id is null");
            if (generators.containsKey(id)) throw new DuplicateIdException("Generator id [" + id + "] is duplicate");

            String executableId = generator.getExecutableId();

            Executable executable = executables.get(executableId);
            if (executable == null) throw new IdNotFoundException(
                    String.format("Executable [id=%s] not found(generator=%s)", executableId, id));

            generators.put(id, new RunnableGenerator(jValuer, executable, new RunInOut(generator.getIn(), generator.getOut())));
        }



        return null;
    }

    private String getExtension(String path) {
        if (path == null) return null;
        if (!path.contains(".")) return null;
        return path.substring(path.lastIndexOf(".") + 1);
    }
}
