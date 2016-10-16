package com.petukhovsky.tpack.task.build;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.jvaluer.util.res.ResourceReader;
import com.petukhovsky.tpack.model.core.TaskModel;
import com.petukhovsky.tpack.task.core.Task;

import java.nio.file.Path;

/**
 * Created by arthur on 12.10.16.
 */
public interface TaskBuilder {
    Task build(TaskModel model, ResourceReader reader, JValuer jValuer, Path storage);
}
