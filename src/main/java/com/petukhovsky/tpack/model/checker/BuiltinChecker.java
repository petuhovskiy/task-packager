package com.petukhovsky.tpack.model.checker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 12.10.16.
 */
public class BuiltinChecker implements Checker{
    private final String name;

    @JsonCreator
    public BuiltinChecker(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
