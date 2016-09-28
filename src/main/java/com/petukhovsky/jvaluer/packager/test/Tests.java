package com.petukhovsky.jvaluer.packager.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class Tests {
    private final int count;
    private final List<TestSet> sets;

    @JsonCreator
    public Tests(@JsonProperty("count") int count, @JsonProperty("sets") List<TestSet> sets) {
        this.count = count;
        this.sets = sets;
    }

    public int getCount() {
        return count;
    }

    public List<TestSet> getSets() {
        return sets;
    }
}
