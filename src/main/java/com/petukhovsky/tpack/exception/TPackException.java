package com.petukhovsky.tpack.exception;

/**
 * Created by arthur on 12.10.16.
 */
public class TPackException extends RuntimeException {
    public TPackException(String s) {
        super(s);
    }

    public TPackException(String s, Throwable t) {
        super(s, t);
    }
}
