package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.BasicInfo;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class BasicInfoParser implements Parser<BasicInfo, JSONObject> {

    @Override
    public ParseResult<BasicInfo> parse(JSONObject json) throws JSONException, ParseException {
        String timeLimit = json.getString("time-limit");
        String memoryLimit = json.getString("memory-limit");
        String in = json.getString("in");
        String out = json.getString("out");

        ParseResult<BasicInfo> result = new ParseResult<>(new BasicInfo(timeLimit, memoryLimit, in, out));
        result.appendWarnings(ParseUtils.unusedKeys(json, "basic", "time-limit", "memory-limit", "in", "out"));

        return result;
    }
}
