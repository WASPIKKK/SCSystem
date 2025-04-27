package com.wasp.scs.file.csv;

import com.wasp.scs.file.AppStorage;

import java.util.List;

public class SupplierCsv extends CsvManager {

    public List<String> readSupplierFromFile() {
        return readFromFile(AppStorage.CSV_FILE_SUPPLIER);
    }

    public void deleteSupplierFromFile(String supplier) {
        deleteFromFile(supplier, AppStorage.CSV_FILE_SUPPLIER, AppStorage.TEMP_CSV_FILE_SUPPLIER);
    }

    public void writeSupplierToFile(String supplier) {
        writeToFile(supplier, AppStorage.CSV_FILE_SUPPLIER);
    }

    public void rewriteSupplierToFile(String supplier) {
        rewriteInFile(supplier, AppStorage.CSV_FILE_SUPPLIER);
    }

    public String findSupplierInFile(long id) {
        return findInFile(id, AppStorage.CSV_FILE_SUPPLIER);
    }
}
