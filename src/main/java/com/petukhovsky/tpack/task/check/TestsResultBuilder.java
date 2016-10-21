package com.petukhovsky.tpack.task.check;

import com.petukhovsky.tpack.task.result.TestingResult;
import com.petukhovsky.tpack.task.tests.Tests;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arthur on 21.10.16.
 */
public abstract class TestsResultBuilder implements ResultBuilder {

    private final Tests tests;

    public TestsResultBuilder(Tests tests) {
        this.tests = tests;
    }

    @Override
    public TestingResult build(CheckProvider provider) {
        return buildResult(tests.getAll().stream().map(test -> new CheckedTest(test, provider.process(test))).collect(Collectors.toList()));
    }

    abstract TestingResult buildResult(List<CheckedTest> list);
}
