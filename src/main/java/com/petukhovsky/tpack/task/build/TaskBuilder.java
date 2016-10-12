package com.petukhovsky.tpack.task.build;

import com.petukhovsky.jvaluer.JValuer;
import com.petukhovsky.tpack.model.core.TaskModel;
import com.petukhovsky.tpack.task.core.Task;

/**
 * Created by arthur on 12.10.16.
 */
public interface TaskBuilder {
    Task build(TaskModel model, JValuer jValuer);
}
