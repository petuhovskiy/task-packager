package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.Source;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class SourceParser implements Parser<Source, JSONObject> {
    @Override
    public ParseResult<Source> parse(JSONObject json) throws JSONException {
        String id = json.getString("id");
        String path = json.getString("path");
        String lang = json.optString("lang", "auto");
        ParseResult<Source> result = new ParseResult<>(new Source(id, path, lang));
        result.appendWarnings(ParseUtils.unusedKeys(json, "source:" + id, "id", "path", "lang"));
        return result;
    }
}
