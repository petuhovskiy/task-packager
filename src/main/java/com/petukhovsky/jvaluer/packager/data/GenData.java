package com.petukhovsky.jvaluer.packager.data;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class GenData implements StringData {
    private String genId;
    private StringData in;
    private String args;

    public GenData() {
    }

    public GenData(String genId, StringData in, String args) {
        this.genId = genId;
        this.in = in;
        this.args = args;
    }

    public String getGenId() {
        return genId;
    }

    public void setGenId(String genId) {
        this.genId = genId;
    }

    public StringData getIn() {
        return in;
    }

    public void setIn(StringData in) {
        this.in = in;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }
}
