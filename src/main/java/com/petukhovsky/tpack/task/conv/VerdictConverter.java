package com.petukhovsky.tpack.task.conv;

import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.run.RunInfo;
import com.petukhovsky.jvaluer.commons.run.RunVerdict;
import com.petukhovsky.tpack.task.check.CheckedRun;
import com.petukhovsky.tpack.task.tests.TestVerdict;

/**
 * Created by arthur on 21.10.16.
 */
public class VerdictConverter {
    public static TestVerdict convert(RunVerdict verdict) {
        switch (verdict) {
            case SUCCESS:
                return TestVerdict.ACCEPTED;
            case CRASH:
                return TestVerdict.INTERNAL_ERROR;
            case SECURITY_VIOLATION:
                return TestVerdict.SECURITY_VIOLATION;
            case FAIL:
                return TestVerdict.INTERNAL_ERROR;
            case IDLENESS_LIMIT_EXCEEDED:
                return TestVerdict.IDLENESS_LIMIT_EXCEEDED;
            case MEMORY_LIMIT_EXCEEDED:
                return TestVerdict.MEMORY_LIMIT_EXCEEDED;
            case RUNTIME_ERROR:
                return TestVerdict.RUNTIME_ERROR;
            case TIME_LIMIT_EXCEEDED:
                return TestVerdict.TIME_LIMIT_EXCEEDED;
            default:
                return null;
        }
    }

    public static TestVerdict convert(CheckedRun run) {
        if (run == null) return TestVerdict.ACCEPTED;
        RunInfo info = run.getInfo();
        if (info == null) return TestVerdict.INTERNAL_ERROR;
        if (info.getRunVerdict() != RunVerdict.SUCCESS) return convert(info.getRunVerdict());
        CheckResult check = run.getCheck();
        if (!check.isCorrect()) return TestVerdict.WRONG_ANSWER;
        return TestVerdict.ACCEPTED;
    }
}
