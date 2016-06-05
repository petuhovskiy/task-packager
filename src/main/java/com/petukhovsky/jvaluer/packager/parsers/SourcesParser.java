package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.Source;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class SourcesParser implements Parser<List<Source>, JSONArray> {

    private SourceParser sourceParser;

    public SourcesParser() {
        this.sourceParser = new SourceParser();
    }

    @Override
    public ParseResult<List<Source>> parse(JSONArray array) throws JSONException, ParseException {
        List<Source> list = new ArrayList<>();
        Set<String> setId = new HashSet<>();
        ParseResult<List<Source>> result = new ParseResult<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = array.getJSONObject(i);
            ParseResult<Source> cur = sourceParser.parse(json);
            Source source = cur.getResult();
            if (setId.contains(source.getId())) throw new ParseException("Duplicate id \"" + source.getId() + "\"");
            setId.add(source.getId());
            list.add(source);
            cur.appendWarningsTo(result);
        }
        result.setResult(list);
        return result;
    }
}
