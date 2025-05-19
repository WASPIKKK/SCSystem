package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Supplier;
import com.wasp.scs.db.csv.SupplierCsv;
import com.wasp.scs.mapper.SupplierMapper;
import com.wasp.scs.mapper.base.EntityMapper;
import com.wasp.scs.repository.SupplierRepository;

import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository {

    private final SupplierCsv supplierCsv = new SupplierCsv();
    private final EntityMapper<Supplier, SupplierCsv> mapper = new SupplierMapper();

    @Override
    public boolean create(Supplier supplier) {
        return supplierCsv.writeSupplierToFile(supplier.toString());
    }

    @Override
    public boolean delete(Supplier supplier) {
        return supplierCsv.deleteSupplierFromFile(supplier.toString());
    }

    @Override
    public Supplier findById(Long id) {
        String tempSupplier = supplierCsv.findSupplierInFile(id);
        if (tempSupplier != null) {
            return mapper.mapToEntity(tempSupplier);
        }
        return null;
    }

    @Override
    public boolean update(Supplier supplier) {
        return supplierCsv.rewriteSupplierToFile(supplier.toString());
    }

    @Override
    public List<Supplier> listSupplier() {
        return mapper.mapToList(supplierCsv);
    }
}
