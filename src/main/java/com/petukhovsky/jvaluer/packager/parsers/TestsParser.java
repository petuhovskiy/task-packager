package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.Test;
import com.petukhovsky.jvaluer.packager.entity.TestSet;
import com.petukhovsky.jvaluer.packager.entity.Tests;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class TestsParser implements Parser<Tests, JSONObject> {

    private final static int MAX_COUNT = 2000;

    private final TestSetsParser testSetsParser;

    public TestsParser() {
        this.testSetsParser = new TestSetsParser();
    }

    @Override
    public ParseResult<Tests> parse(JSONObject json) throws JSONException, ParseException {
        int count = json.getInt("count");
        if (count > MAX_COUNT) throw new ParseException("too many tests");
        if (count < 0) throw new ParseException("tests count bad value");

        ParseResult<List<TestSet>> tmp = testSetsParser.parse(json.getJSONArray("sets"));

        Test[] tests = new Test[count];

        ParseResult<Tests> result = new ParseResult<>();
        tmp.appendWarningsTo(result);

        for (TestSet set : tmp.getResult()) {
            if (set.getLastTest() > count) throw new ParseException("testset interval doesn't fit in count");

            for (int test = set.getFirstTest(); test <= set.getLastTest(); test++) {
                if (tests[test - 1] != null) throw new ParseException("testsets intersection at test #" + test);
                tests[test - 1] = set.getTest();
            }
        }

        for (int i = 1; i <= count; i++) {
            if (tests[i - 1] == null) throw new ParseException("test #" + i + " is missing");
        }

        result.setResult(new Tests(tests));
        return result;
    }
}
