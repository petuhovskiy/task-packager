package com.petukhovsky.tpack.task.gen;

import com.petukhovsky.jvaluer.commons.data.GeneratedData;
import com.petukhovsky.jvaluer.commons.data.TestData;
import com.petukhovsky.jvaluer.commons.run.RunLimits;

/**
 * Created by arthur on 12.10.16.
 */
//TODO: move to JValuer commons
public interface Generator {
    GeneratedData generate(TestData in, RunLimits limits, String... args);
}
