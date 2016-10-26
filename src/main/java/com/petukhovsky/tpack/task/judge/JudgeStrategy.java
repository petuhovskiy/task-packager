package com.petukhovsky.tpack.task.judge;

import com.petukhovsky.jvaluer.commons.test.result.TestingResult;

/**
 * Created by arthur on 21.10.16.
 */
public interface JudgeStrategy {
    TestingResult judge(InvocationProvider provider, JudgeCallback judgeCallback);
}
