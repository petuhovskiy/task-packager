package com.petukhovsky.jvaluer.packager.data;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class InMemoryData implements StringData {
    private String data;

    public InMemoryData() {
    }

    public InMemoryData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
