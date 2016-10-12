package com.petukhovsky.tpack.model.score;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Arthur Petukhovsky on 6/9/2016.
 */
public class ScoreModel implements ResultModel {
    private final double maxScore;

    @JsonCreator
    public ScoreModel(@JsonProperty("maxScore") double maxScore) {
        this.maxScore = maxScore;
    }

    public double getMaxScore() {
        return maxScore;
    }
}
