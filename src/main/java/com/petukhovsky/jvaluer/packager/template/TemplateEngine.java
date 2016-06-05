package com.petukhovsky.jvaluer.packager.template;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Arthur Petukhovsky on 6/5/2016.
 */
public interface TemplateEngine {
    String process(String template, Map model) throws IOException, TemplateException;
}
