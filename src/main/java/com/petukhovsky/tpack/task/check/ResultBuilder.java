package com.petukhovsky.tpack.task.check;

import com.petukhovsky.jvaluer.commons.test.result.TestingResult;

/**
 * Created by arthur on 12.10.16.
 */
public interface ResultBuilder {
    TestingResult build(CheckProvider provider);
}
