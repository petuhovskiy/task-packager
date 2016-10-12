package com.petukhovsky.tpack.model.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SourceModel {
    private final String id;
    private final String path;
    private final String lang;

    @JsonCreator
    public SourceModel(@JsonProperty("id") String id, @JsonProperty("path") String path, @JsonProperty("lang") String lang) {
        this.id = id;
        this.path = path;
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getLang() {
        return lang;
    }
}
