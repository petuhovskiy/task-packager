package com.petukhovsky.tpack.exception;

/**
 * Created by arthur on 13.10.16.
 */
public class DuplicateIdException extends TPackBuildException {
    public DuplicateIdException(String s) {
        super(s);
    }

    public DuplicateIdException(String s, Throwable t) {
        super(s, t);
    }
}
