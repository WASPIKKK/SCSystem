package com.wasp.scs.service.impl;

import com.wasp.scs.entity.Supplier;
import com.wasp.scs.enums.ActionStatus;
import com.wasp.scs.repository.SupplierRepository;
import com.wasp.scs.repository.impl.SupplierRepositoryImpl;
import com.wasp.scs.service.SupplierService;
import com.wasp.scs.db.counter.base.CounterManager;
import com.wasp.scs.db.counter.SupplierCounter;
import com.wasp.scs.service.validator.ValidatorService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService, ValidatorService<Supplier> {

    private final SupplierRepository repository = new SupplierRepositoryImpl();
    private final CounterManager counterManager = new SupplierCounter();

    @Override
    public ActionStatus create(Supplier supplier) {
        if(!isValid(supplier)){
            return ActionStatus.INVALID_INPUT;
        }

        if (counterManager.generateNextId()) {
            int id = counterManager.getCurrentId();
            supplier.setId(id);
            if (repository.create(supplier)) {
                return ActionStatus.SUCCESS;
            } else {
                counterManager.restorePreviousId();
            }
        }

        return ActionStatus.FAILED;
    }

    @Override
    public ActionStatus delete(long id) {
        Supplier supplier = repository.findById(id);

        if (!isValid(supplier)) {
            return ActionStatus.INVALID_INPUT;
        }

        if(repository.delete(id)){
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    @Override
    public ActionStatus update(long id, String name) {
        Supplier supplier = repository.findById(id);

        if (!isValid(supplier)) {
            return ActionStatus.INVALID_INPUT;
        }

        supplier.setName(name);
        if (repository.update(supplier)) {
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return repository.listSupplier();
    }
}
