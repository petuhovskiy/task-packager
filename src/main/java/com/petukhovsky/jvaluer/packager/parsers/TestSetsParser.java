package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.TestSet;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class TestSetsParser implements Parser<List<TestSet>, JSONArray> {

    private TestSetParser testSetParser;

    public TestSetsParser() {
        this.testSetParser = new TestSetParser();
    }

    @Override
    public ParseResult<List<TestSet>> parse(JSONArray array) throws JSONException, ParseException {
        List<TestSet> list = new ArrayList<>();
        ParseResult<List<TestSet>> result = new ParseResult<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = array.getJSONObject(i);
            ParseResult<TestSet> cur = testSetParser.parse(json);
            TestSet testSet = cur.getResult();
            list.add(testSet);
            cur.appendWarningsTo(result);
        }
        result.setResult(list);
        return result;
    }
}
