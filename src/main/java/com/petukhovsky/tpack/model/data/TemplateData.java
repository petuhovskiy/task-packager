package com.petukhovsky.tpack.model.data;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class TemplateData implements StringData {
    private final String path; //pattern

    public TemplateData(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
