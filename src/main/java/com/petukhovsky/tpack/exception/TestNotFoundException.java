package com.petukhovsky.tpack.exception;

/**
 * Created by arthur on 12.10.16.
 */
public class TestNotFoundException extends TestBuildException {
    public TestNotFoundException(int index) {
        super("Test #" + index + " not found");
    }
}
