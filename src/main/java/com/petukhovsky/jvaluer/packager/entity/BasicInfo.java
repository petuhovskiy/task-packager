package com.petukhovsky.jvaluer.packager.entity;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class BasicInfo {
    String timeLimit;
    String memoryLimit;
    String in;
    String out;

    public BasicInfo() {
    }

    public BasicInfo(String timeLimit, String memoryLimit, String in, String out) {
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.in = in;
        this.out = out;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(String memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
}
