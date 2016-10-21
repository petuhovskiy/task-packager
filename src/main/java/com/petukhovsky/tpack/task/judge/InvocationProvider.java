package com.petukhovsky.tpack.task.judge;

import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.run.InvocationResult;

/**
 * Created by arthur on 21.10.16.
 */
public interface InvocationProvider {
    InvocationResult run(TestData in);
}
