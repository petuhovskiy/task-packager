package com.petukhovsky.tpack.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by Arthur Petukhovsky on 6/5/2016.
 */
public class TemplateEngineImpl implements TemplateEngine {

    private final static Configuration configuration;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
    }

    public TemplateEngineImpl() {

    }

    /* TODO: unsafe template execution */

    @Override
    public String process(String template, Map<String, ?> model) throws IOException, TemplateException {
        Template t = new Template("template", new StringReader(template), configuration);

        StringWriter stringWriter = new StringWriter();

        t.process(model, stringWriter);

        return stringWriter.toString();
    }
}
