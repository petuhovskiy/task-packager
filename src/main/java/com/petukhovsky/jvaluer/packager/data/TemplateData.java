package com.petukhovsky.jvaluer.packager.data;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class TemplateData implements StringData {
    private String path;

    public TemplateData() {
    }

    public TemplateData(String path) {

        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
