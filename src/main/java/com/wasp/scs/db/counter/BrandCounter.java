package com.wasp.scs.db.counter;

import com.wasp.scs.constant.StorageConstant;
import com.wasp.scs.db.counter.base.CounterManager;

import java.io.File;

public class BrandCounter extends CounterManager {

    private static final String DIR_PATH = String.format("%s/%s/%s/%s", StorageConstant.GENERAL_DIR, StorageConstant.CATALOG_DIR, "brand", StorageConstant.COUNT_DIR);
    private final File counterFile;

    public BrandCounter() {
        this.counterFile = prepareDirAndFile(DIR_PATH);
    }

    @Override
    public boolean generateNextId() {
        return writeToFile(counterFile, false);
    }

    @Override
    public void restorePreviousId() {
        writeToFile(counterFile, true);
    }
}
