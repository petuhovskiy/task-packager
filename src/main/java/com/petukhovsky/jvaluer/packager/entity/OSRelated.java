package com.petukhovsky.jvaluer.packager.entity;

import java.util.Map;

/**
 * Created by Arthur Petukhovsky on 6/6/2016.
 */
public class OSRelated<T> {
    private Map<String, T> map;

    public OSRelated(Map<String, T> map) {
        this.map = map;
    }

    public T get(String os) {
        if (map.containsKey(os)) return map.get(os);
        return map.get("default");
    }
}
