package com.petukhovsky.jvaluer.packager.score;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.petukhovsky.jvaluer.packager.exe.CompiledExecutable;
import com.petukhovsky.jvaluer.packager.exe.NativeExecutable;

/**
 * Created by Arthur Petukhovsky on 6/9/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ScoreModel.class, name = "score"),
        @JsonSubTypes.Type(value = VerdictModel.class, name = "verdict")
})
public interface ResultModel {
}
