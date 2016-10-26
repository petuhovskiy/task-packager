import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.JValuerBuilder;
import com.petukhovsky.jvaluer.commons.compiler.CloneCompiler;
import com.petukhovsky.jvaluer.commons.compiler.RunnableCompiler;
import com.petukhovsky.jvaluer.commons.lang.Language;
import com.petukhovsky.jvaluer.commons.local.OSRelatedValue;
import com.petukhovsky.jvaluer.commons.test.result.TestingResult;
import com.petukhovsky.jvaluer.invoker.CustomInvoker;
import com.petukhovsky.jvaluer.run.RunnerBuilder;
import com.petukhovsky.jvaluer.run.SafeRunner;
import com.petukhovsky.jvaluer.util.FilesUtils;
import com.petukhovsky.jvaluer.util.res.ClassResourceReader;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.model.core.TaskModel;
import com.petukhovsky.tpack.task.build.TaskBuilderImpl;
import com.petukhovsky.tpack.task.build.TaskBuilder;
import com.petukhovsky.tpack.task.core.Task;
import com.petukhovsky.tpack.task.judge.JudgeStrategy;
import com.petukhovsky.tpack.task.judge.TaskDefaultStrategy;
import com.petukhovsky.tpack.template.FreemarkerEngine;
import com.petukhovsky.tpack.template.TemplateEngine;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arthur on 21.10.16.
 */
public class TaskTest {

    private ObjectMapper objectMapper;
    private JValuer jValuer;
    private TemplateEngine templateEngine;
    private TaskBuilder taskBuilder;

    @Before
    public void init() {
        this.objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        this.jValuer = new JValuerBuilder()
                .addLanguage(new Language("GNU C++11",
                                new RunnableCompiler("g++", "{defines} -O2 -o {output} {source}")),
                        new String[]{"cpp"},
                        new String[]{"c++11", "cpp11", "cpp"})
                .addLanguage(new Language("Python 3",
                                new CloneCompiler(),
                                new CustomInvoker(new OSRelatedValue<String>()
                                        .windows("c:/Programs/Python-3/python.exe")
                                        .orElse("python3"),
                                        "{exe} {args}")),
                        new String[]{"py"},
                        new String[]{"python", "py", "python3"})
                .setPath(Paths.get("/data/jvaluer/tmp/"))
                .build();
        this.templateEngine = new FreemarkerEngine();
        this.taskBuilder = new TaskBuilderImpl(jValuer, templateEngine);
    }

    @Test
    public void test() throws IOException {
        ResourceReader reader = new ClassResourceReader(TaskTest.class, "/apb/");
        TaskModel model = objectMapper.readValue(reader.openInputStream("index.json"), TaskModel.class);
        System.out.println(objectMapper.writeValueAsString(model));

        Path storage = Paths.get("/data/tmp/task/");
        FilesUtils.assureEmptyDir(storage);
        Task task = taskBuilder.build(model, reader, storage);

        SafeRunner safeRunner = new RunnerBuilder(jValuer)
                .inOut(task.getInfo().getInOut())
                .limits(task.getInfo().getLimits())
                .buildSafe(task.getExecutables().get("solution"));

        JudgeStrategy strategy = new TaskDefaultStrategy(task);

        TestingResult testingResult = strategy.judge(data -> safeRunner.run(data),
                callback -> {
                    try {
                        System.out.println(objectMapper.writeValueAsString(callback));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(objectMapper.writeValueAsString(testingResult));
    }
}
