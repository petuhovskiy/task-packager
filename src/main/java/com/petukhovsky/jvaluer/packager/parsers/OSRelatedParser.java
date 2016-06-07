package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.OSRelated;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class OSRelatedParser<T> implements Parser<OSRelated<T>, JSONObject> {

    @Override
    public ParseResult<OSRelated<T>> parse(JSONObject json) throws JSONException, ParseException {
        Map<String, T> map = new HashMap<>();
        for (String key : json.keySet()) {
            map.put(key, (T) json.get(key));
        }
        return new ParseResult<>(new OSRelated<>(map));
    }
}
