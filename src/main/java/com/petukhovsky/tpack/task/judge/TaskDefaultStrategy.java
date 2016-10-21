package com.petukhovsky.tpack.task.judge;

import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.checker.Checker;
import com.petukhovsky.jvaluer.commons.run.InvocationResult;
import com.petukhovsky.jvaluer.commons.run.RunVerdict;
import com.petukhovsky.tpack.task.check.CheckProvider;
import com.petukhovsky.tpack.task.check.CheckedRun;
import com.petukhovsky.tpack.task.check.ResultBuilder;
import com.petukhovsky.tpack.task.core.Task;
import com.petukhovsky.tpack.task.result.TestingResult;
import com.petukhovsky.tpack.task.tests.Test;

/**
 * Created by arthur on 21.10.16.
 */
public class TaskDefaultStrategy implements JudgeStrategy {

    private final Checker checker;
    private final ResultBuilder resultBuilder;

    public TaskDefaultStrategy(Task task) {
        this.resultBuilder = task.getResultBuilder();
        this.checker = task.getChecker();
    }

    @Override
    public TestingResult judge(InvocationProvider provider, JudgeCallback callback) {
        return resultBuilder.build(test -> {
            InvocationResult inv = provider.run(test.getInData());
            if (inv.getRun().getRunVerdict() != RunVerdict.SUCCESS) {
                callback.callback(new JudgeTestInfo(test, inv, null));
                return new CheckedRun(inv.getRun(), null);
            }
            CheckResult checkResult = checker.check(test.getInData(), test.getAnswerData(), inv.getOut(), null, inv.getRun());
            callback.callback(new JudgeTestInfo(test, inv, checkResult));
            return new CheckedRun(inv.getRun(), checkResult);
        });
    }
}
