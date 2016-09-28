package com.petukhovsky.jvaluer.packager.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.petukhovsky.jvaluer.packager.score.ScoreModel;
import com.petukhovsky.jvaluer.packager.score.VerdictModel;

/**
 * Created by Arthur Petukhovsky on 6/5/2016.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InMemoryData.class, name = "string"),
        @JsonSubTypes.Type(value = PathData.class, name = "file"),
        @JsonSubTypes.Type(value = GenData.class, name = "gen"),
        @JsonSubTypes.Type(value = TemplateData.class, name = "template")
})
public interface StringData {
}
