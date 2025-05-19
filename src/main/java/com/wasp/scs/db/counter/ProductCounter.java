package com.wasp.scs.db.counter;

import com.wasp.scs.db.counter.base.CounterManager;

import java.io.File;

public class ProductCounter extends CounterManager {

    @Override
    public boolean generateNextId() {
        return false;
    }

    @Override
    public void restorePreviousId() {

    }

    @Override
    public int getCurrentId() {
        return super.getCurrentId();
    }

    @Override
    protected boolean writeToFile(File file, boolean isRollback) {
        return super.writeToFile(file, isRollback);
    }

    @Override
    protected String readFile(File file) {
        return super.readFile(file);
    }

    @Override
    protected File prepareDirAndFile(String dirPath) {
        return super.prepareDirAndFile(dirPath);
    }
}
