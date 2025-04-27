package com.wasp.scs.service.impl;

import com.wasp.scs.entity.Supplier;
import com.wasp.scs.repository.SupplierRepository;
import com.wasp.scs.service.SupplierService;
import com.wasp.scs.service.counter.CounterService;
import com.wasp.scs.service.counter.impl.SupplierCounterImpl;

import java.util.List;


public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;
    private final CounterService counterService = new SupplierCounterImpl();

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Supplier supplier) {

    }

    @Override
    public void delete(Supplier supplier) {

    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public List<Supplier> listSupplier() {
        return List.of();
    }
}
