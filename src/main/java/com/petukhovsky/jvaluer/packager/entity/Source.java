package com.petukhovsky.jvaluer.packager.entity;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class Source {
    private String id;
    private String path;
    private String lang;

    public Source(String id, String path, String lang) {
        this.id = id;
        this.path = path;
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
