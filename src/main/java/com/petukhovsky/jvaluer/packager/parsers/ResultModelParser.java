package com.petukhovsky.jvaluer.packager.parsers;

import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parser.ParseUtils;
import com.petukhovsky.jvaluer.packager.parser.Parser;
import com.petukhovsky.jvaluer.packager.score.ResultModel;
import com.petukhovsky.jvaluer.packager.score.ScoreModel;
import com.petukhovsky.jvaluer.packager.score.VerdictModel;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arthur Petukhovsky on 6/9/2016.
 */
public class ResultModelParser implements Parser<ResultModel, JSONObject> {

    private final ScoreModelParser scoreModelParser;

    public ResultModelParser() {
        this.scoreModelParser = new ScoreModelParser();
    }

    @Override
    public ParseResult<ResultModel> parse(JSONObject json) throws JSONException, ParseException {
        ParseResult<ResultModel> result = new ParseResult<>();

        String model = json.getString("type");
        switch (model) {
            case "verdict":
                result.appendWarnings(ParseUtils.unusedKeys(json, "scoring", "type"));
                result.setResult(new VerdictModel());
                break;
            case "score":
                result.appendWarnings(ParseUtils.unusedKeys(json, "scoring", "type", "score"));
                ParseResult<ScoreModel> tmp = scoreModelParser.parse(json.getJSONObject("score"));
                tmp.appendWarningsTo(result);
                result.setResult(tmp.getResult());
                break;
            default:
                throw new ParseException("unknown scoring type");
        }

        return result;
    }
}
