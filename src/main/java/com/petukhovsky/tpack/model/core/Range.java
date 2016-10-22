package com.petukhovsky.tpack.model.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
                return i <= last;
            }

            @Override
            public Integer next() {
                return i++;
            }
        };
    }
}
