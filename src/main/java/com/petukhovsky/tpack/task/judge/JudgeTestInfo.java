package com.petukhovsky.tpack.task.judge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.run.InvocationResult;
import com.petukhovsky.tpack.task.tests.Test;

/**
 * Created by arthur on 21.10.16.
 */
public class JudgeTestInfo {
    private final Test test;
    private final InvocationResult result;
    private final CheckResult check;

    @JsonCreator
    public JudgeTestInfo(@JsonProperty("test") Test test,
                         @JsonProperty("result") InvocationResult result,
                         @JsonProperty("check") CheckResult check) {
        this.test = test;
        this.result = result;
        this.check = check;
    }

    public Test getTest() {
        return test;
    }

    public InvocationResult getResult() {
        return result;
    }

    public CheckResult getCheck() {
        return check;
    }
}
