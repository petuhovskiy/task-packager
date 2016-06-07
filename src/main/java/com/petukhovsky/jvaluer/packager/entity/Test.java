package com.petukhovsky.jvaluer.packager.entity;

import com.petukhovsky.jvaluer.packager.data.StringData;

/**
 * Created by Arthur Petukhovsky on 6/7/2016.
 */
public class Test {
    private StringData in;
    private StringData out;

    public Test(StringData in, StringData out) {
        this.in = in;
        this.out = out;
    }

    public StringData getIn() {

        return in;
    }

    public void setIn(StringData in) {
        this.in = in;
    }

    public StringData getOut() {
        return out;
    }

    public void setOut(StringData out) {
        this.out = out;
    }
}
