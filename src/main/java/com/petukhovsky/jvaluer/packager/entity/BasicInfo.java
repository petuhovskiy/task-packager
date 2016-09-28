package com.petukhovsky.jvaluer.packager.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class BasicInfo {
    private final String timeLimit;
    private final String memoryLimit;
    private final String in;
    private final String out;

    @JsonCreator
    public BasicInfo(@JsonProperty("timeLimit") String timeLimit,
                     @JsonProperty("memoryLimit") String memoryLimit,
                     @JsonProperty("in") String in,
                     @JsonProperty("out") String out) {
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.in = in;
        this.out = out;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public String getMemoryLimit() {
        return memoryLimit;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }
}
