package com.petukhovsky.tpack.model.exe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 28.9.16.
 */
public class CompiledModel implements ExecutableModel {
    private final String id;
    private final String sourceId;

    @JsonCreator
    public CompiledModel(@JsonProperty("id") String id, @JsonProperty("sourceId") String sourceId) {
        this.id = id;
        this.sourceId = sourceId;
    }

    public String getId() {
        return id;
    }

    public String getSourceId() {
        return sourceId;
    }
}
