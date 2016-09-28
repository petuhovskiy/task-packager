package com.petukhovsky.jvaluer.packager.exe;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by arthur on 28.9.16.
 */
public class CompiledExecutable implements Executable{
    private final String id;
    private final String sourceId;

    @JsonCreator
    public CompiledExecutable(@JsonProperty("id") String id, @JsonProperty("sourceId") String sourceId) {
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
