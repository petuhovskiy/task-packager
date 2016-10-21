import com.fasterxml.jackson.databind.ObjectMapper;
import com.petukhovsky.jvaluer.JValuerBuilder;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.model.core.TaskModel;
import com.petukhovsky.tpack.util.ClassResourceReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by arthur on 21.10.16.
 */
public class TaskTest {

    private ObjectMapper objectMapper;

    @Before
    public void init() {
        this.objectMapper = new ObjectMapper();

    }

    @Test
    public void test() throws IOException {
        ResourceReader reader = new ClassResourceReader(TaskTest.class, "/apb/");
        TaskModel model = objectMapper.readValue(reader.openInputStream("index.json"), TaskModel.class);
        System.out.println(objectMapper.writeValueAsString(model));
    }
}
