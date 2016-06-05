package com.petukhovsky.jvaluer.packager.parser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Arthur Petukhovsky on 6/3/2016.
 */
public class ParseUtils {
    public static List<ParseWarning> unusedKeys(JSONObject object, String id, String... keys) {
        Set<String> used = Arrays.stream(keys).collect(Collectors.toSet());
        List<ParseWarning> list = new ArrayList<>();
        for (String key : object.keySet()) {
            if (used.contains(key)) continue;
            list.add(new ParseWarning("Unused key \"" + key + "\" in " + id));
        }
        return list;
    }
}
