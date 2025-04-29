package com.wasp.scs.file.csv;

import com.wasp.scs.file.AppStorage;

import java.io.File;
import java.util.List;

public class BrandCsv extends CsvManager {

    private final File csv = new File(AppStorage.CSV_BRAND_DIR,"brand.csv");

    public List<String> readBrandFromFile() {
        return readFromFile(csv);
    }

    public void deleteBrandFromFile(String brand) {
        deleteFromFile(brand, csv);
    }

    public void writeBrandToFile(String brand) {
        writeToFile(brand, csv);
    }

    public void rewriteBrandToFile(String brand) {
        rewriteInFile(brand, csv);
    }

    public String findBrandInFile(long id) {
        return findInFile(id, csv);
    }
}
