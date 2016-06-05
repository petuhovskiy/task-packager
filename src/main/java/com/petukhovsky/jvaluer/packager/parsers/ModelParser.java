package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.Executable;
import com.petukhovsky.jvaluer.packager.entity.Source;
import com.petukhovsky.jvaluer.packager.entity.TaskModel;
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

    private final String os;
    private final SourcesParser sourcesParser;
    private final ExecutablesParser executablesParser;

    public ModelParser(String os) {
        this.os = os;
        this.sourcesParser = new SourcesParser();
        this.executablesParser = new ExecutablesParser(os);
    }

    public ModelParser() {
        this("default");
    }

    @Override
    public ParseResult<TaskModel> parse(JSONObject json) throws JSONException, ParseException {
        ParseResult<TaskModel> result = new ParseResult<>();

        String id;
        List<Source> sources;
        List<Executable> executables;

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

        id = json.getString("id");

        result.appendWarnings(ParseUtils.unusedKeys(json, "task:" + id, "id", "sources", "executables"));
        result.setResult(new TaskModel(id, sources, executables));

        return result;
    }
}
