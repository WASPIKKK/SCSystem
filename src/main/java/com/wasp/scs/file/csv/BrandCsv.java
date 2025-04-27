package com.wasp.scs.file.csv;

import com.wasp.scs.file.AppStorage;

import java.util.List;

public class BrandCsv extends CsvManager {

    public List<String> readBrandFromFile() {
        return readFromFile(AppStorage.CSV_FILE_BRAND);
    }

    public void deleteBrandFromFile(String brand) {
        deleteFromFile(brand, AppStorage.CSV_FILE_BRAND, AppStorage.TEMP_CSV_FILE_BRAND);
    }

    public void writeBrandToFile(String brand) {
        writeToFile(brand, AppStorage.CSV_FILE_BRAND);
    }

    public void rewriteBrandToFile(String brand) {
        rewriteInFile(brand, AppStorage.CSV_FILE_BRAND);
    }

    public String findBrandInFile(long id) {
        return findInFile(id, AppStorage.CSV_FILE_BRAND);
    }
}
