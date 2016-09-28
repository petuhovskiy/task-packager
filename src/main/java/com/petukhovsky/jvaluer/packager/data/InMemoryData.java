package com.petukhovsky.jvaluer.packager.data;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class InMemoryData implements StringData {
    private final String data; //pattern

    public InMemoryData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
