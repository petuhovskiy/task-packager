package com.petukhovsky.tpack.exception;

import com.petukhovsky.tpack.task.tests.Test;

/**
 * Created by arthur on 12.10.16.
 */
public class TestAlreadyExists extends TestBuildException {
    public TestAlreadyExists(int index) {
        super("Test #" + index + " already exists");
    }
}
