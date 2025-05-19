package com.wasp.scs.mapper;

import com.wasp.scs.db.csv.SupplierCsv;
import com.wasp.scs.entity.Supplier;
import com.wasp.scs.mapper.base.EntityMapper;

import java.util.ArrayList;
import java.util.List;

public class SupplierMapper extends EntityMapper<Supplier, SupplierCsv> {

    public List<Supplier> mapToList(SupplierCsv supplierCsv) {
        List<String> listSupplierString = supplierCsv.readSupplierFromFile();
        List<Supplier> listSupplier = new ArrayList<>();

        for (String temp : listSupplierString) {
            Supplier tempSupplier = mapToEntity(temp);
            listSupplier.add(tempSupplier);
        }

        return listSupplier;
    }

    @Override
    public Supplier mapToEntity(String supplierString) {
        String[] arraySupplier = supplierString.split(";", 2);
        Supplier newSupplier = new Supplier(arraySupplier[1]);
        newSupplier.setId(Integer.parseInt(arraySupplier[0]));
        return newSupplier;
    }
}
