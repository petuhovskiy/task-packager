package com.petukhovsky.tpack.model.data;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class TemplateData implements StringData {
    private final String string; //pattern, TODO: path

    public TemplateData(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
