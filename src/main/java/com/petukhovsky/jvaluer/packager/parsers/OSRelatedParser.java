package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class OSRelatedParser<T> implements Parser<T, JSONObject> {
    private String os;

    public OSRelatedParser(String os) {
        this.os = os;
    }

    public OSRelatedParser() {
        this("default");
    }

    @Override
    public ParseResult<T> parse(JSONObject json) throws JSONException, ParseException {
        if (json.has(os)) return new ParseResult<>((T) json.get(os));
        return new ParseResult<>((T) json.get("default"));
    }
}
