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
        if (isValid(supplier)) {
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
        return ActionStatus.INVALID_INPUT;
    }

    @Override
    public ActionStatus delete(Supplier supplier) {
        if (isValid(supplier)) {
            if (repository.delete(supplier)) {
                return ActionStatus.SUCCESS;
            }
            return ActionStatus.FAILED;
        }
        return ActionStatus.INVALID_INPUT;
    }

    @Override
    public ActionStatus update(Supplier supplier) {
        Supplier newSupplier = repository.findById(supplier.getId());
        if (isValid(newSupplier)) {
            newSupplier.setName(supplier.getName());
            if (repository.update(newSupplier)) {
                return ActionStatus.SUCCESS;
            }
            return ActionStatus.FAILED;
        }
        return ActionStatus.INVALID_INPUT;
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return repository.listSupplier();
    }


    @Override
    public boolean isValid(Supplier supplier) {
        return supplier != null && supplier.getName() != null && !supplier.getName().isEmpty();
    }
}
