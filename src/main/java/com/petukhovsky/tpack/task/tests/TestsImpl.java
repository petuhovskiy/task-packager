package com.petukhovsky.tpack.task.tests;

import com.petukhovsky.tpack.exception.TestAlreadyExists;
import com.petukhovsky.tpack.exception.TestIllegalIndexException;
import com.petukhovsky.tpack.exception.TestNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arthur on 12.10.16.
 */
public class TestsImpl implements Tests {

    private final List<Test> tests;

    private TestsImpl(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public List<Test> getAll() {
        return tests;
    }

    @Override
    public Test get(int index) {
        return tests.get(index);
    }

    static class Builder {

        private int count;
        private Test[] all;

        Builder(int count) {
            this.count = count;
            this.all = new Test[count];
        }

        void assertIndex(int index) {
            if (index < 1 || index > count) throw new TestIllegalIndexException(index, 1, count);
            if (all[index - 1] != null) throw new TestAlreadyExists(index + 1);
        }

        void add(Test test) {
            int index = test.getIndex();
            assertIndex(index);
            all[index - 1] = test;
        }

        void verify() {
            for (int i = 0; i < count; i++) {
                if (all[i] == null) throw new TestNotFoundException(i + 1);
                if (all[i].getIndex() != i + 1) throw new TestIllegalIndexException(all[i].getIndex(), i + 1, i + 1);
            }
        }

        Tests build() {
            verify();
            return new TestsImpl(Arrays.asList(all));
        }
    }
}
