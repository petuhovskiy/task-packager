package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.entity.Executable;
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
public class ExecutablesParser implements Parser<List<Executable>, JSONArray> {

    private final ExecutableParser executableParser;
    private final String os;

    public ExecutablesParser(String os) {
        this.os = os;
        this.executableParser = new ExecutableParser(os);
    }

    public ExecutablesParser() {
        this("default");
    }

    @Override
    public ParseResult<List<Executable>> parse(JSONArray array) throws JSONException, ParseException {
        List<Executable> list = new ArrayList<>();
        Set<String> setId = new HashSet<>();
        ParseResult<List<Executable>> result = new ParseResult<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject json = array.getJSONObject(i);
            ParseResult<Executable> cur = executableParser.parse(json);
            Executable executable = cur.getResult();
            if (setId.contains(executable.getId()))
                throw new ParseException("Duplicate id \"" + executable.getId() + "\"");
            setId.add(executable.getId());
            list.add(executable);
            cur.appendWarningsTo(result);
        }
        result.setResult(list);
        return result;
    }
}
