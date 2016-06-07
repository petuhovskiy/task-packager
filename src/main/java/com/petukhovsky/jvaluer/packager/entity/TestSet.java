package com.petukhovsky.jvaluer.packager.entity;

/**
 * Created by Arthur Petukhovsky on 6/5/2016.
 */
public class TestSet {
    private int firstTest;
    private int lastTest;
    private Test test;

    public TestSet(int firstTest, int lastTest, Test test) {
        this.firstTest = firstTest;
        this.lastTest = lastTest;
        this.test = test;
    }

    public int getFirstTest() {

        return firstTest;
    }

    public void setFirstTest(int firstTest) {
        this.firstTest = firstTest;
    }

    public int getLastTest() {
        return lastTest;
    }

    public void setLastTest(int lastTest) {
        this.lastTest = lastTest;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
