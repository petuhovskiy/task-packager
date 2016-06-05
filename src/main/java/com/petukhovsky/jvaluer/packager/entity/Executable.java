package com.petukhovsky.jvaluer.packager.entity;

/**
 * Created by Arthur Petukhovsky on 5/31/2016.
 */
public class Executable {
    private String id;
    private String value;
    private String type;
    private String in;
    private String out;

    public Executable() {
    }

    public Executable(String id, String value, String type, String in, String out) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.in = in;
        this.out = out;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
