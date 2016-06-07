package com.petukhovsky.jvaluer.packager.entity;

import java.util.List;

/**
 * Created by Arthur Petukhovsky on 5/31/2016.
 */
public class TaskModel {
    private String id;

    private List<Source> sources;
    private List<Executable> executables;

    private BasicInfo info;
    private Tests tests;

    public TaskModel(String id, List<Source> sources, List<Executable> executables, BasicInfo info, Tests tests) {
        this.sources = sources;
        this.id = id;
        this.executables = executables;
        this.info = info;
        this.tests = tests;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Executable> getExecutables() {
        return executables;
    }

    public void setExecutables(List<Executable> executables) {
        this.executables = executables;
    }

    public BasicInfo getInfo() {
        return info;
    }

    public void setInfo(BasicInfo info) {
        this.info = info;
    }

    public Tests getTests() {
        return tests;
    }

    public void setTests(Tests tests) {
        this.tests = tests;
    }
}
