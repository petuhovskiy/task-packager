package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.Executable;
import com.petukhovsky.jvaluer.packager.entity.OSRelated;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class ExecutableParser implements Parser<Executable, JSONObject> {

    private OSRelatedParser osRelatedParser;

    public ExecutableParser() {
        this.osRelatedParser = new OSRelatedParser();
    }

    @Override
    public ParseResult<Executable> parse(JSONObject json) throws JSONException, ParseException {
        String id = json.getString("id");
        String in = json.optString("in", "stdin");
        String out = json.optString("out", "stdout");
        OSRelated<String> value;
        String type;

        ParseResult<Executable> result = new ParseResult<>();

        if (json.has("compiled") == json.has("binary")) {
            throw new ParseException("required one of compiler and binary in executable:" + id);
        }

        if (json.has("compiled")) {
            type = "compiled";
            ParseResult<OSRelated<String>> tmp = osRelatedParser.parse(json.getJSONObject("compiled"));
            tmp.appendWarningsTo(result);
            value = tmp.getResult();
        } else {
            type = "binary";
            ParseResult<OSRelated<String>> tmp = osRelatedParser.parse(json.getJSONObject("binary"));
            tmp.appendWarningsTo(result);
            value = tmp.getResult();
        }

        result.appendWarnings(ParseUtils.unusedKeys(json, "executable:" + id, "id", "in", "out", "compiled", "binary"));
        result.setResult(new Executable(id, value, type, in, out));

        return result;
    }
}
