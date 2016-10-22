package com.petukhovsky.tpack.task.tests;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.petukhovsky.jvaluer.commons.data.StringData;
import com.petukhovsky.jvaluer.commons.data.TestData;

/**
 * Created by arthur on 12.10.16.
 */
@JsonSerialize(using = TestSerializer.class)
public interface Test {
    TestData getInData();
    TestData getAnswerData();
    int getIndex();
}
