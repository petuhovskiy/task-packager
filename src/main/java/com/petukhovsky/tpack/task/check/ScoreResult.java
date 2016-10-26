package com.petukhovsky.tpack.task.check;

import com.petukhovsky.jvaluer.commons.run.RunVerdict;
import com.petukhovsky.jvaluer.commons.test.result.ScoreTestingResult;
import com.petukhovsky.jvaluer.commons.test.result.TestingResult;
import com.petukhovsky.tpack.task.conv.VerdictConverter;
import com.petukhovsky.jvaluer.commons.test.TestVerdict;
import com.petukhovsky.tpack.task.tests.Tests;

import java.util.List;

/**
 * Created by arthur on 21.10.16.
 */
public class ScoreResult extends TestsResultBuilder {

    private final double cost;

    public ScoreResult(Tests tests, int count, double max) {
        super(tests);
        this.cost = count == 0 ? 0 : max / count;
    }

    @Override
    TestingResult buildResult(List<CheckedTest> list) {
        double result = 0;
        int count = 0;

        TestVerdict verdict = TestVerdict.ACCEPTED;
        Integer testIndex = null;

        for (CheckedTest checked : list) {
            count++;

            CheckedRun run = checked.getRun();
            if (testIndex == null && run.getInfo().getRunVerdict() != RunVerdict.SUCCESS) {
                testIndex = checked.getTest().getIndex();
                verdict = VerdictConverter.convert(run.getInfo().getRunVerdict());
            }

            result += checked.getRun().getCheck().getResult() * cost;
        }
        return new ScoreTestingResult(true, count, verdict, testIndex, result);
    }
}
