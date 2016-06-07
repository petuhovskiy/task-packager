package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.data.StringData;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class StringDataParser implements Parser<StringData, JSONObject> {
    @Override
    public ParseResult<StringData> parse(JSONObject json) throws JSONException, ParseException {
        //TODO
        return null;
    }
}
