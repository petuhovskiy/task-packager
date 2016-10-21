package com.petukhovsky.tpack.task.check;

import com.petukhovsky.jvaluer.commons.checker.CheckResult;
import com.petukhovsky.jvaluer.commons.run.RunInfo;

/**
 * Created by arthur on 21.10.16.
 */
public class CheckedRun {
    private final RunInfo info;
    private final CheckResult check;

    public CheckedRun(RunInfo info, CheckResult check) {
        this.info = info;
        this.check = check;
    }

    public RunInfo getInfo() {
        return info;
    }

    public CheckResult getCheck() {
        return check;
    }
}
