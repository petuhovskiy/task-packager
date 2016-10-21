package com.petukhovsky.tpack.task.check;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.commons.checker.Checker;
import com.petukhovsky.jvaluer.commons.exe.Executable;
import com.petukhovsky.tpack.exception.TPackBuildException;
import com.petukhovsky.tpack.model.checker.BuiltinChecker;
import com.petukhovsky.tpack.template.TemplateEngine;

import java.util.Map;

/**
 * Created by arthur on 21.10.16.
 */
public class CheckerConverter {
    private final JValuer jValuer;
    private final TemplateEngine templateEngine;

    public CheckerConverter(JValuer jValuer, TemplateEngine templateEngine) {
        this.jValuer = jValuer;
        this.templateEngine = templateEngine;
    }

    public Checker convert(com.petukhovsky.tpack.model.checker.Checker checker, Map<String, Executable> executables) {
        if (checker instanceof BuiltinChecker) {
            Checker result = jValuer.builtin().checker(((BuiltinChecker) checker).getName());
            if (result == null) throw new TPackBuildException("can't find builtin checker \'" + ((BuiltinChecker) checker).getName() + "\'");
            return result;
        } else {
            throw new UnsupportedOperationException("unsupported checker");
        }
    }
}
