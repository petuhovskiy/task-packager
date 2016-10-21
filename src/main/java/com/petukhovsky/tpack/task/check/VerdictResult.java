package com.petukhovsky.tpack.task.check;

import com.petukhovsky.jvaluer.commons.run.RunInfo;
import com.petukhovsky.jvaluer.commons.run.RunVerdict;
import com.petukhovsky.tpack.task.conv.VerdictConverter;
import com.petukhovsky.tpack.task.result.TestingResult;
import com.petukhovsky.tpack.task.tests.Test;
import com.petukhovsky.tpack.task.tests.TestVerdict;
import com.petukhovsky.tpack.task.tests.Tests;

/**
 * Created by arthur on 21.10.16.
 */
public class VerdictResult implements ResultBuilder {

    private final Tests tests;

    public VerdictResult(Tests tests) {
        this.tests = tests;
    }

    @Override
    public TestingResult build(CheckProvider provider) {
        boolean correct = true;
        int count = 0;

        CheckedRun incorrect = null;
        Integer incorrectIndex = null;

        for (Test test : tests.getAll()) {
            count++;
            CheckedRun run = provider.process(test);
            if (run.getCheck() == null || run.getInfo() == null
                    || run.getInfo().getRunVerdict() != RunVerdict.SUCCESS || !run.getCheck().isCorrect()) {
                correct = false;
                incorrect = run;
                incorrectIndex = test.getIndex();
                break;
            }
        }
        return new TestingResult(correct, count, VerdictConverter.convert(incorrect), incorrectIndex);
    }
}
