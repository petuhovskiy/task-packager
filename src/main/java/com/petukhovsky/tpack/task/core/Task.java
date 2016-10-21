package com.petukhovsky.tpack.task.core;

import com.petukhovsky.jvaluer.commons.checker.Checker;
import com.petukhovsky.jvaluer.commons.gen.Generator;
import com.petukhovsky.jvaluer.commons.source.Source;
import com.petukhovsky.tpack.model.core.BasicInfo;
import com.petukhovsky.tpack.task.check.ResultBuilder;
import com.petukhovsky.tpack.task.tests.Tests;

import java.nio.file.Path;
import java.util.Map;

/**
 * Created by arthur on 12.10.16.
 */
public class Task {
    private final Map<String, Source> sources;
    private final Map<String, Path> executables;
    private final Map<String, Generator> generators;

    private final Tests tests;
    private final BasicInfo info;
    private final Checker checker;
    private final ResultBuilder result;

    public Task(Map<String, Source> sources, Map<String, Path> executables, Map<String, Generator> generators, Tests tests, BasicInfo info, Checker checker, ResultBuilder result) {
        this.sources = sources;
        this.executables = executables;
        this.generators = generators;
        this.tests = tests;
        this.info = info;
        this.checker = checker;
        this.result = result;
    }

    public Map<String, Source> getSources() {
        return sources;
    }

    public Map<String, Path> getExecutables() {
        return executables;
    }

    public Map<String, Generator> getGenerators() {
        return generators;
    }

    public Tests getTests() {
        return tests;
    }

    public BasicInfo getInfo() {
        return info;
    }

    public Checker getChecker() {
        return checker;
    }

    public ResultBuilder getResult() {
        return result;
    }
}
