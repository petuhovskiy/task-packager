package com.petukhovsky.tpack.task.tests;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.commons.data.PathData;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.exe.Executable;
import com.petukhovsky.jvaluer.commons.gen.Generator;
import com.petukhovsky.jvaluer.commons.run.InvocationResult;
import com.petukhovsky.jvaluer.commons.run.RunVerdict;
import com.petukhovsky.jvaluer.run.Runner;
import com.petukhovsky.jvaluer.run.RunnerBuilder;
import com.petukhovsky.jvaluer.run.SafeRunner;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.exception.TPackBuildException;
import com.petukhovsky.tpack.exception.TestBuildException;
import com.petukhovsky.tpack.model.test.TestSet;
import com.petukhovsky.tpack.model.test.TestsModel;
import com.petukhovsky.tpack.task.data.DataConverter;
import com.petukhovsky.tpack.template.TemplateEngine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Map;

/**
 * Created by arthur on 18.10.16.
 */
public class TestsBuilder {
    private final JValuer jValuer;
    private final TemplateEngine templateEngine;
    private final DataConverter dataConverter;

    public TestsBuilder(JValuer jValuer, TemplateEngine templateEngine) {
        this.jValuer = jValuer;
        this.templateEngine = templateEngine;
        this.dataConverter = new DataConverter(jValuer, templateEngine);
    }

    public Tests build(Map<String, Generator> generators, SafeRunner solver, TestsModel tests, ResourceReader reader, Path storage) {
        TestsImpl.Builder builder = new TestsImpl.Builder(tests.getCount());
        for (TestSet set : tests.getSets()) {
            for (int index : set.getRange()) {
                builder.assertIndex(index);
                TestData data = dataConverter.convert(set.getIn(), Collections.singletonMap("test", index), generators, reader);

                Path pathIn = storage.resolve(index + ".in");
                try(InputStream is = data.openInputStream()) {
                    Files.copy(is, pathIn, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new TPackBuildException("failed to copy test #" + index);
                }
                PathData in = new PathData(pathIn);
                PathData out = null;

                if (solver != null) {
                    Path outPath = storage.resolve(index + ".out");
                    InvocationResult invocationResult = solver.run(in, outPath);
                    if (invocationResult.getRun().getRunVerdict() != RunVerdict.SUCCESS) {
                        throw new TestBuildException("Test #" + index + " Model solution has failed; " + invocationResult.getRun().toString());
                    }
                    out = new PathData(outPath);
                }

                builder.add(new TestImpl(in, out, index));
            }
        }
        return builder.build();
    }
}
