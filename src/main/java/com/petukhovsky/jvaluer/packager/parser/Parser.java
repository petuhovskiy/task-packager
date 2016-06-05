package com.petukhovsky.jvaluer.packager.parser;

import org.json.JSONException;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public interface Parser<T, J> {
    ParseResult<T> parse(J json) throws JSONException, ParseException;
}
