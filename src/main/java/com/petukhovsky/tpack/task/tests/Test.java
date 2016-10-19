package com.petukhovsky.tpack.task.tests;

import com.petukhovsky.jvaluer.commons.data.StringData;
import com.petukhovsky.jvaluer.commons.data.TestData;

/**
 * Created by arthur on 12.10.16.
 */
public interface Test {
    TestData getInData();
    TestData getAnswerData();
    int getIndex();
}
