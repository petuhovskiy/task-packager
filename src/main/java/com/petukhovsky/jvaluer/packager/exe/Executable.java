package com.petukhovsky.jvaluer.packager.exe;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Arthur Petukhovsky on 5/31/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompiledExecutable.class, name = "compiled"),
        @JsonSubTypes.Type(value = NativeExecutable.class, name = "native")
})
public interface Executable {
}
