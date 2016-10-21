package com.petukhovsky.tpack.task.check;

import com.petukhovsky.tpack.task.tests.Test;

/**
 * Created by arthur on 21.10.16.
 */
public interface CheckProvider {
    CheckedRun process(Test test);
}
