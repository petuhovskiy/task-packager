package com.petukhovsky.tpack.task.tests;

import com.petukhovsky.jvaluer.commons.data.TestData;

/**
 * Created by arthur on 12.10.16.
 */
public class TestImpl implements Test {
    private final TestData data;
    private final int index;

    public TestImpl(TestData data, int index) {
        this.data = data;
        this.index = index;
    }

    public TestData getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }
}
