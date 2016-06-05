package com.petukhovsky.jvaluer.packager.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class ParseResult<T> {
    private T result;
    private List<ParseWarning> warnings;

    public ParseResult() {
        this.warnings = new ArrayList<>();
    }

    public ParseResult(T object) {
        this();
        this.result = object;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<ParseWarning> getWarnings() {
        return warnings;
    }

    public void appendWarning(ParseWarning warning) {
        warnings.add(warning);
    }

    public void appendWarnings(Collection<ParseWarning> warnings) {
        this.warnings.addAll(warnings);
    }

    public void appendWarningsTo(ParseResult result) {
        result.appendWarnings(this.warnings);
    }
}
