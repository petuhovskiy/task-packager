package com.petukhovsky.tpack.exception;

/**
 * Created by arthur on 12.10.16.
 */
public class TestIllegalIndexException extends TestBuildException {
    public TestIllegalIndexException(int index, int l, int r) {
        super("Test #" + index + " not in range[" + l + ", " + r + "]");
    }
}
