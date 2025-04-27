package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Supplier;
import com.wasp.scs.file.csv.SupplierCsv;
import com.wasp.scs.repository.SupplierRepository;

import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository {

    private final SupplierCsv supplierCsv = new SupplierCsv();

    @Override
    public void create(Supplier supplier) {
        supplierCsv.writeSupplierToFile(supplier.toString());
    }

    @Override
    public void delete(Supplier supplier) {
        supplierCsv.deleteSupplierFromFile(supplier.toString());
    }

    @Override
    public Supplier findById(Long id) {
        String tempSupplier = supplierCsv.findSupplierInFile(id);
        if (tempSupplier != null) {
            //return BrandMapper.stringToBrand(tempSupplier);
        }
        return null;
    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public List<Supplier> listSupplier() {
        return List.of();
    }
}
