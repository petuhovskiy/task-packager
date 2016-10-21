package com.petukhovsky.tpack.task.result;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.petukhovsky.tpack.model.score.ScoreModel;
import com.petukhovsky.tpack.model.score.VerdictModel;
import com.petukhovsky.tpack.task.tests.TestVerdict;

/**
 * Created by arthur on 21.10.16.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ScoreTestingResult.class, name = "score"),
        @JsonSubTypes.Type(value = TestingResult.class, name = "verdict")
})
public class TestingResult {
    private final boolean accepted;
    private final int testsJudged;
    private final TestVerdict verdict;
    private final Integer testWithVerdict;

    public TestingResult(boolean accepted, int testsJudged, TestVerdict verdict, Integer testWithVerdict) {
        this.accepted = accepted;
        this.testsJudged = testsJudged;
        this.verdict = verdict;
        this.testWithVerdict = testWithVerdict;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public int getTestsJudged() {
        return testsJudged;
    }

    public TestVerdict getVerdict() {
        return verdict;
    }

    public Integer getTestWithVerdict() {
        return testWithVerdict;
    }
}
