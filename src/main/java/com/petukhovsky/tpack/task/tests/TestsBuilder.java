package com.petukhovsky.tpack.task.tests;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.commons.data.PathData;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.exe.Executable;
import com.petukhovsky.jvaluer.commons.gen.Generator;
import com.petukhovsky.jvaluer.run.Runner;
import com.petukhovsky.jvaluer.run.RunnerBuilder;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.exception.TPackBuildException;
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

    public Tests build(Map<String, Generator> generators, Executable solution, TestsModel tests, ResourceReader reader, Path storage) {
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

                if (solution != null) {

                }
            }
        }
        return builder.build();
    }
}
