package com.petukhovsky.tpack.task.tests;

import java.util.List;

/**
 * Created by arthur on 12.10.16.
 */
public interface Tests {
    List<Test> getAll();
    Test get(int index);
}
