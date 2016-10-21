package com.petukhovsky.tpack.util;

import com.petukhovsky.jvaluer.commons.data.PathData;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by arthur on 21.10.16.
 */
public class ClassResourceReader implements ResourceReader {

    private final Class c;
    private final String pref;

    public ClassResourceReader(Class c, String pref) {
        this.c = c;
        this.pref = pref;
    }

    @Override
    public String readString(String s) {
        InputStream is = openInputStream(s);
        if (is == null) return null;
        try {
            return IOUtils.toString(is, "UTF-8");
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public InputStream openInputStream(String s) {
        return c.getResourceAsStream(pref + s);
    }

    @Override
    public boolean exists(String s) {
        try (InputStream is = openInputStream(s)) {
            return is != null;
        } catch (IOException e) {
            return false;
        }
    }
}
