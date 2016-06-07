package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.*;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class ModelParser implements Parser<TaskModel, JSONObject> {

    private final SourcesParser sourcesParser;
    private final ExecutablesParser executablesParser;
    private final BasicInfoParser basicInfoParser;
    private final TestsParser testsParser;

    public ModelParser() {
        this.sourcesParser = new SourcesParser();
        this.executablesParser = new ExecutablesParser();
        this.basicInfoParser = new BasicInfoParser();
        this.testsParser = new TestsParser();
    }

    @Override
    public ParseResult<TaskModel> parse(JSONObject json) throws JSONException, ParseException {
        ParseResult<TaskModel> result = new ParseResult<>();

        String id;
        List<Source> sources;
        List<Executable> executables;
        BasicInfo info;
        Tests tests;

        {
            ParseResult<List<Source>> tmp = sourcesParser.parse(json.getJSONArray("sources"));
            tmp.appendWarningsTo(result);
            sources = tmp.getResult();
        }

        {
            ParseResult<List<Executable>> tmp = executablesParser.parse(json.getJSONArray("executables"));
            tmp.appendWarningsTo(result);
            executables = tmp.getResult();
        }

        {
            ParseResult<BasicInfo> tmp = basicInfoParser.parse(json.getJSONObject("basic"));
            tmp.appendWarningsTo(result);
            info = tmp.getResult();
        }

        {
            ParseResult<Tests> tmp = testsParser.parse(json.getJSONObject("tests"));
            tmp.appendWarningsTo(result);
            tests = tmp.getResult();
        }

        id = json.getString("id");

        result.appendWarnings(ParseUtils.unusedKeys(json, "task:" + id, "id", "sources", "executables", "basic", "tests"));
        result.setResult(new TaskModel(id, sources, executables, info, tests));

        return result;
    }
}
