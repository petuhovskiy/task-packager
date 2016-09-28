package com.petukhovsky.jvaluer.packager.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class GenData implements StringData {
    private final String genId;
    private final StringData in;
    private final String args; //pattern

    @JsonCreator
    public GenData(@JsonProperty("genId") String genId,
                   @JsonProperty("in") StringData in,
                   @JsonProperty("args") String args) {
        this.genId = genId;
        this.in = in;
        this.args = args;
    }

    public String getGenId() {
        return genId;
    }

    public StringData getIn() {
        return in;
    }

    public String getArgs() {
        return args;
    }
}
