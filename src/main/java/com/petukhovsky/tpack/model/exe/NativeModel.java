package com.petukhovsky.tpack.model.exe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 28.9.16.
 */
public class NativeModel implements ExecutableModel {
    private final String id;
    private final String path; //TODO: make this os related

    @JsonCreator
    public NativeModel(@JsonProperty("id") String id, @JsonProperty("path") String path) {
        this.id = id;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
}
