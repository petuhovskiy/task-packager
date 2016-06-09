package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.data.GenData;
import com.petukhovsky.jvaluer.packager.data.StringData;
import com.petukhovsky.jvaluer.packager.entity.Test;
import com.petukhovsky.jvaluer.packager.entity.TestSet;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class TestSetParser implements Parser<TestSet, JSONObject> {

    private final StringDataParser stringDataParser;

    public TestSetParser() {
        this.stringDataParser = new StringDataParser();
    }

    @Override
    public ParseResult<TestSet> parse(JSONObject json) throws JSONException, ParseException {
        if (json.has("first") != json.has("last")) {
            throw new ParseException("both first and last are required");
        }
        if (json.has("first") == json.has("single")) {
            throw new ParseException("single conflicts with first and last");
        }

        int first, last;
        first = json.optInt("first", json.optInt("single", -1));
        last = json.optInt("last", json.optInt("single", -1));

        if (first > last) throw new ParseException("bad testset interval(first > last)");
        if (first < 1) throw new ParseException("bad testset interval(first < 1)");

        if (json.has("out") == json.has("out-solve")) {
            throw new ParseException("either out or out-solve is required");
        }

        ParseResult<TestSet> result = new ParseResult<>();

        StringData in, out;

        {
            ParseResult<StringData> tmp = stringDataParser.parse(json.getJSONObject("in"));
            in = tmp.getResult();
            tmp.appendWarningsTo(result);
        }

        if (json.has("out-solve")) out = new GenData(json.getString("out-solve"), in, "");
        else {
            ParseResult<StringData> tmp = stringDataParser.parse(json.getJSONObject("out"));
            out = tmp.getResult();
            tmp.appendWarningsTo(result);
        }

        result.setResult(new TestSet(first, last, new Test(in, out)));

        return result;
    }
}
