package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import com.petukhovsky.jvaluer.packager.score.ScoreModel;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/9/2016.
 */
public class ScoreModelParser implements Parser<ScoreModel, JSONObject> {
    @Override
    public ParseResult<ScoreModel> parse(JSONObject json) throws JSONException, ParseException {
        ParseResult<ScoreModel> result = new ParseResult<>();
        result.appendWarnings(ParseUtils.unusedKeys(json, "score", "max-score"));

        double maxScore = json.getDouble("max-score");

        result.setResult(new ScoreModel(maxScore));

        return result;
    }
}
