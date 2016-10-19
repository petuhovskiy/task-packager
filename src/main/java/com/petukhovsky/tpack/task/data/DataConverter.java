package com.petukhovsky.tpack.task.data;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.commons.data.*;
import com.petukhovsky.jvaluer.commons.gen.Generator;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.exception.TPackBuildException;
import com.petukhovsky.tpack.model.data.*;
import com.petukhovsky.tpack.model.data.PathData;
import com.petukhovsky.tpack.model.data.StringData;
import com.petukhovsky.tpack.template.TemplateEngine;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

/**
 * Created by arthur on 19.10.16.
 */
public class DataConverter {
    private final JValuer jValuer;
    private final TemplateEngine templateEngine;

    public DataConverter(JValuer jValuer, TemplateEngine templateEngine) {
        this.jValuer = jValuer;
        this.templateEngine = templateEngine;
    }

    public TestData convert(StringData data, Map<String, ?> template, Map<String, Generator> generators, ResourceReader reader) {
        if (data instanceof GenData) {
            throw new UnsupportedOperationException("GenData isn't supported now");
        } else if (data instanceof InMemoryData) {
            return new com.petukhovsky.jvaluer.commons.data.StringData(((InMemoryData) data).getData());
        } else if (data instanceof TemplateData) {
            try {
                return new com.petukhovsky.jvaluer.commons.data.StringData(templateEngine.process(((TemplateData) data).getString(), template));
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
                throw new TPackBuildException("can't process template");
            }
        } else if (data instanceof PathData) {
            Path path = jValuer.createTempFile("", ".in");
            String relative;
            try {
                relative = templateEngine.process(((PathData) data).getPath(), template);
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
                throw new TPackBuildException("can't process template");
            }
            try(InputStream is = reader.openInputStream(relative)) {
                Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
                throw new TPackBuildException("error while reading " + relative);
            }
            return new com.petukhovsky.jvaluer.commons.data.PathData(path);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
