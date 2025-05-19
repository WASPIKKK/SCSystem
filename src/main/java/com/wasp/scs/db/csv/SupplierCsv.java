package com.wasp.scs.db.csv;

import com.wasp.scs.constant.StorageConstant;
import com.wasp.scs.db.csv.base.EntityCsvManager;

import java.io.File;
import java.util.List;

public class SupplierCsv extends EntityCsvManager {

    private static final String FILE_NAME = "supplier.csv";
    private static final String DIR_PATH = String.format("%s/%s/%s/%s",
            StorageConstant.GENERAL_DIR,
            StorageConstant.CATALOG_DIR, "supplier",
            StorageConstant.CSV_DIR);
    private final File supplierFile;

    public SupplierCsv() {
        this.supplierFile = prepareDirAndFile(DIR_PATH, FILE_NAME);
    }

    public boolean writeSupplierToFile(String supplier) {
        return writeToFile(supplier, supplierFile);
    }

    public List<String> readSupplierFromFile() {
        return readFromFile(supplierFile);
    }

    public boolean deleteSupplierFromFile(String supplier) {
        return deleteFromFile(supplier, supplierFile);
    }

    public boolean rewriteSupplierToFile(String supplier) {
        return rewriteToFile(supplier, supplierFile);
    }

    public String findSupplierInFile(long id) {
        return findInFile(id, supplierFile);
    }
}
