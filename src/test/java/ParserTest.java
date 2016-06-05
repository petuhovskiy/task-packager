import com.petukhovsky.jvaluer.packager.entity.TaskModel;
import com.petukhovsky.jvaluer.packager.parser.ParseException;
import com.petukhovsky.jvaluer.packager.parser.ParseResult;
import com.petukhovsky.jvaluer.packager.parsers.ModelParser;
import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class ParserTest {
    @Test
    public void test() throws ParseException {
        ModelParser modelParser = new ModelParser();

        InputStream stream = ParserTest.class.getResourceAsStream("/model.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String model = br.lines().collect(Collectors.joining("\n"));

        JSONObject json = new JSONObject(model);
        json = json.getJSONObject("task");
        ParseResult<TaskModel> result = modelParser.parse(json);
        System.out.println(new JSONObject(result));
    }
}
