package com.wasp.scs.service.counter.impl;

import com.wasp.scs.file.AppStorage;
import com.wasp.scs.service.counter.CounterService;
import com.wasp.scs.util.SequenceUtil;

public class SupplierCounterImpl implements CounterService {

    @Override
    public int getNextId() {
        return SequenceUtil.readAndUpdate(AppStorage.COUNT_FILE_SUPPLIER, AppStorage.TEMP_COUNT_FILE_SUPPLIER);
    }
}
