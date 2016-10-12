package com.petukhovsky.tpack.model.score;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
