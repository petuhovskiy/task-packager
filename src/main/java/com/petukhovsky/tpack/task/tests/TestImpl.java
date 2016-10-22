package com.petukhovsky.tpack.task.tests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.petukhovsky.jvaluer.commons.data.TestData;

/**
 * Created by arthur on 12.10.16.
 */
public class TestImpl implements Test {
    private final TestData in;
    private final TestData answer;

    private final int index;

    public TestImpl(TestData in, TestData answer, int index) {
        this.in = in;
        this.answer = answer;
        this.index = index;
    }

    @Override
    public TestData getInData() {
        return in;
    }

    @Override
    public TestData getAnswerData() {
        return answer;
    }

    public int getIndex() {
        return index;
    }
}
