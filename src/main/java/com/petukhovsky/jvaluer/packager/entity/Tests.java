package com.petukhovsky.jvaluer.packager.entity;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class Tests {
    private int count;
    private Test[] tests; //offset 1

    public Tests(Test[] tests) {
        this.tests = tests;
        this.count = tests.length;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Test[] getTests() {
        return tests;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }

    public Test getTest(int index) {
        return tests[index - 1];
    }

    public void setTest(int index, Test test) {
        tests[index - 1] = test;
    }
}
