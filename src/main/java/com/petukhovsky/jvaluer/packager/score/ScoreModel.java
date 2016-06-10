package com.petukhovsky.jvaluer.packager.score;

/**
 * Created by Arthur Petukhovsky on 6/9/2016.
 */
public class ScoreModel implements ResultModel {
    private double maxScore;

    public ScoreModel() {
    }

    public ScoreModel(double maxScore) {

        this.maxScore = maxScore;
    }

    public double getMaxScore() {

        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }
}
