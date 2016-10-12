package com.petukhovsky.tpack.model.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.tpack.model.checker.Checker;
import com.petukhovsky.tpack.model.exe.ExecutableModel;
import com.petukhovsky.tpack.model.gen.GeneratorModel;
import com.petukhovsky.tpack.model.score.ResultModel;
import com.petukhovsky.tpack.model.test.TestsModel;

import java.util.List;

/**
 * Created by Arthur Petukhovsky on 5/31/2016.
 */
public class TaskModel {

    private final List<SourceModel> sources;
    private final List<ExecutableModel> executables;
    private final List<GeneratorModel> generators;

    private final BasicInfo info;
    private final TestsModel tests;
    private final ResultModel result;
    private final Checker checker;

    @JsonCreator
    public TaskModel(@JsonProperty("sources") List<SourceModel> sources,
                     @JsonProperty("executables") List<ExecutableModel> executables,
                     @JsonProperty("generators") List<GeneratorModel> generators,
                     @JsonProperty("info") BasicInfo info,
                     @JsonProperty("tests") TestsModel tests,
                     @JsonProperty("result") ResultModel result,
                     @JsonProperty("checker") Checker checker) {
        this.sources = sources;
        this.executables = executables;
        this.generators = generators;
        this.info = info;
        this.tests = tests;
        this.result = result;
        this.checker = checker;
    }

    public List<SourceModel> getSources() {
        return sources;
    }

    public List<ExecutableModel> getExecutables() {
        return executables;
    }

    public BasicInfo getInfo() {
        return info;
    }

    public TestsModel getTests() {
        return tests;
    }

    public ResultModel getResult() {
        return result;
    }

    public List<GeneratorModel> getGenerators() {
        return generators;
    }

    public Checker getChecker() {
        return checker;
    }
}
