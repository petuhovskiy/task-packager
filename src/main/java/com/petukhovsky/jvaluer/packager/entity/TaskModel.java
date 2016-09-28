package com.petukhovsky.jvaluer.packager.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.packager.exe.Executable;
import com.petukhovsky.jvaluer.packager.gen.Generator;
import com.petukhovsky.jvaluer.packager.score.ResultModel;
import com.petukhovsky.jvaluer.packager.test.Tests;

import java.util.List;

/**
 * Created by Arthur Petukhovsky on 5/31/2016.
 */
public class TaskModel {

    private final List<Source> sources;
    private final List<Executable> executables;
    private final List<Generator> generators;

    private final BasicInfo info;
    private final Tests tests;
    private final ResultModel result;

    @JsonCreator
    public TaskModel(@JsonProperty("sources") List<Source> sources,
                     @JsonProperty("executables") List<Executable> executables,
                     @JsonProperty("generators") List<Generator> generators,
                     @JsonProperty("info") BasicInfo info,
                     @JsonProperty("tests") Tests tests,
                     @JsonProperty("result") ResultModel result) {
        this.sources = sources;
        this.executables = executables;
        this.generators = generators;
        this.info = info;
        this.tests = tests;
        this.result = result;
    }

    public List<Source> getSources() {
        return sources;
    }

    public List<Executable> getExecutables() {
        return executables;
    }

    public BasicInfo getInfo() {
        return info;
    }

    public Tests getTests() {
        return tests;
    }

    public ResultModel getResult() {
        return result;
    }

    public List<Generator> getGenerators() {
        return generators;
    }
}
