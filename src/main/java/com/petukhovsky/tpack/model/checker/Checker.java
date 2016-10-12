package com.petukhovsky.tpack.model.checker;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by arthur on 12.10.16.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BuiltinChecker.class, name = "builtin")
        //@JsonSubTypes.Type(value = NativeExecutable.class, name = "exe")
})
public interface Checker {
}
