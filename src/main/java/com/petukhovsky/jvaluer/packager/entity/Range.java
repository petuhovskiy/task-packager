package com.petukhovsky.jvaluer.packager.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xerces.internal.dom.RangeImpl;

import java.util.Iterator;

/**
 * Created by arthur on 28.9.16.
 */
public class Range implements Iterable<Integer> {
    private final int first;
    private final int last;

    @JsonCreator
    public Range(@JsonProperty("first") int first, @JsonProperty("last") int last) {
        this.first = first;
        this.last = last;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = first;

            @Override
            public boolean hasNext() {
                return i != last;
            }

            @Override
            public Integer next() {
                return i++;
            }
        };
    }
}
