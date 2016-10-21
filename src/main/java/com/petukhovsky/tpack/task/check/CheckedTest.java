package com.petukhovsky.tpack.task.check;

import com.petukhovsky.tpack.task.tests.Test;

/**
 * Created by arthur on 21.10.16.
 */
public class CheckedTest {
    private final Test test;
    private final CheckedRun run;

    public CheckedTest(Test test, CheckedRun run) {
        this.test = test;
        this.run = run;
    }

    public Test getTest() {
        return test;
    }

    public CheckedRun getRun() {
        return run;
    }
}
