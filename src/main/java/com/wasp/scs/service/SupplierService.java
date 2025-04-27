package com.wasp.scs.service;

import com.wasp.scs.entity.Supplier;

import java.util.List;

public interface SupplierService {

    void create(Supplier supplier);

    void delete(Supplier supplier);

    void update(Supplier supplier);

    List<Supplier> listSupplier();
}
