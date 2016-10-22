package com.petukhovsky.tpack.task.judge;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by arthur on 21.10.16.
 */
public interface JudgeCallback {
    void callback(JudgeTestInfo judgeTestInfo);
}
