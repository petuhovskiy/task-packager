package com.petukhovsky.tpack.model.exe;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Arthur Petukhovsky on 5/31/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompiledModel.class, name = "compiled"),
        @JsonSubTypes.Type(value = NativeModel.class, name = "native")
})
public interface ExecutableModel {
}
