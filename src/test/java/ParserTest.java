import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petukhovsky.jvaluer.commons.exe.Executable;
import com.petukhovsky.tpack.model.core.TaskModel;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class ParserTest {

    public static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    @Test
    public void executable() throws IOException {
        String exe = "{\n" +
                "        \"type\": \"compiled\",\n" +
                "        \"id\": \"solution\",\n" +
                "        \"sourceId\": \"solution\"\n" +
                "      }";
        Executable executable = objectMapper().readValue(exe, Executable.class);
        System.out.println(objectMapper().writeValueAsString(executable));
    }

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = objectMapper();
        JsonNode task = objectMapper.readTree(ParserTest.class.getResourceAsStream("/model.json"));
        TaskModel taskModel = objectMapper.treeToValue(task, TaskModel.class);
        System.out.println(objectMapper.writeValueAsString(taskModel));
    }

    @Test
    public void testSimple() throws IOException {
        ObjectMapper objectMapper = objectMapper();
        JsonNode task = objectMapper.readTree(ParserTest.class.getResourceAsStream("/simple.json"));
        TaskModel taskModel = objectMapper.treeToValue(task, TaskModel.class);
        System.out.println(objectMapper.writeValueAsString(taskModel));
    }
}
