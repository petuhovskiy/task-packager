package com.petukhovsky.jvaluer.packager.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class PathData implements StringData {
    private final String path; //pattern

    @JsonCreator
    public PathData(@JsonProperty("path") String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
