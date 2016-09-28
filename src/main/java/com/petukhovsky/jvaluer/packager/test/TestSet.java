package com.petukhovsky.jvaluer.packager.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petukhovsky.jvaluer.packager.data.StringData;
import com.petukhovsky.jvaluer.packager.entity.Range;

/**
 * Created by Arthur Petukhovsky on 6/5/2016.
 */
public class TestSet {
    private final StringData in;
    private final Range range;

    @JsonCreator
    public TestSet(@JsonProperty("in") StringData in, @JsonProperty("range") Range range) {
        this.in = in;
        this.range = range;
    }

    public StringData getIn() {
        return in;
    }

    public Range getRange() {
        return range;
    }
}
