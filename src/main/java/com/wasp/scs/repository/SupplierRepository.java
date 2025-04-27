package com.wasp.scs.repository;

import com.wasp.scs.entity.Supplier;

import java.util.List;

public interface SupplierRepository {

    void create(Supplier supplier);

    void delete(Supplier supplier);

    Supplier findById(Long id);

    void update(Supplier supplier);

    List<Supplier> listSupplier();
}
