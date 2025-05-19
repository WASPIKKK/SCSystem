package com.wasp.scs.repository;

import com.wasp.scs.entity.Supplier;

import java.util.List;

public interface SupplierRepository {

    boolean create(Supplier supplier);

    boolean delete(Supplier supplier);

    Supplier findById(Long id);

    boolean update(Supplier supplier);

    List<Supplier> listSupplier();
}
