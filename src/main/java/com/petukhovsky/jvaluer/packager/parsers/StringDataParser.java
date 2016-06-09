package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.data.*;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class StringDataParser implements Parser<StringData, JSONObject> {
    @Override
    public ParseResult<StringData> parse(JSONObject json) throws JSONException, ParseException {
        boolean model1 = json.has("path");
        boolean model2 = json.has("data");
        boolean model3 = json.has("gen") || json.has("in") || json.has("args");
        boolean model4 = json.has("pattern-file");
        int count = 0;
        if (model1) count++;
        if (model2) count++;
        if (model3) count++;
        if (model4) count++;
        if (count != 1) throw new ParseException("bad StringData");
        ParseResult<StringData> result = new ParseResult<>();
        result.appendWarnings(ParseUtils.unusedKeys(json, "path", "data", "gen", "in", "args", "pattern-file"));
        if (model1) {
            result.setResult(new PathData(json.getString("path")));
        }
        if (model2) {
            result.setResult(new InMemoryData(json.getString("data")));
        }
        if (model3) {
            StringData data;
            if (json.has("in")) {
                ParseResult<StringData> tmp = parse(json.getJSONObject("in"));
                tmp.appendWarningsTo(result);
                data = tmp.getResult();
            } else {
                data = new InMemoryData("");
            }
            result.setResult(new GenData(json.getString("gen"), data, json.optString("args", "")));
        }
        if (model4) {
            result.setResult(new TemplateData(json.getString("pattern-file")));
        }
        return result;
    }
}
