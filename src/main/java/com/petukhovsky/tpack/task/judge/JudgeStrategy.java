package com.petukhovsky.tpack.task.judge;

import com.petukhovsky.tpack.task.result.TestingResult;

/**
 * Created by arthur on 21.10.16.
 */
public interface JudgeStrategy {
    TestingResult judge(InvocationProvider provider, JudgeCallback judgeCallback);
}
