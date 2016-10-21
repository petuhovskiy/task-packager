package com.petukhovsky.tpack.task.result;

import com.petukhovsky.tpack.task.tests.TestVerdict;

/**
 * Created by arthur on 21.10.16.
 */
public class ScoreTestingResult extends TestingResult {

    private final double score;

    public ScoreTestingResult(boolean accepted, int testsJudged, TestVerdict verdict, Integer testWithVerdict, double score) {
        super(accepted, testsJudged, verdict, testWithVerdict);
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
