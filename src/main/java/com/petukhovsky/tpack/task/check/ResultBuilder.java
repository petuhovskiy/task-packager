package com.petukhovsky.tpack.task.check;

import com.petukhovsky.tpack.task.result.TestingResult;

/**
 * Created by arthur on 12.10.16.
 */
public interface ResultBuilder {
    TestingResult build(CheckProvider provider);
}
