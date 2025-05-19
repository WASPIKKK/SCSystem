package com.wasp.scs.db.csv;

import com.wasp.scs.constant.StorageConstant;
import com.wasp.scs.db.csv.base.EntityCsvManager;

import java.io.File;
import java.util.List;

public class BrandCsv extends EntityCsvManager {

    private static final String FILE_NAME = "brand.csv";
    private static final String DIR_PATH = String.format("%s/%s/%s/%s",
            StorageConstant.GENERAL_DIR,
            StorageConstant.CATALOG_DIR, "brand",
            StorageConstant.CSV_DIR);
    private final File brandFile;

    public BrandCsv() {
        this.brandFile = prepareDirAndFile(DIR_PATH, FILE_NAME);
    }

    public List<String> readBrandFromFile() {
        return readFromFile(brandFile);
    }

    public boolean deleteBrandFromFile(String brand) {
        return deleteFromFile(brand, brandFile);
    }

    public boolean writeBrandToFile(String brand) {
        return writeToFile(brand, brandFile);
    }

    public boolean rewriteBrandToFile(String brand) {
        return rewriteToFile(brand, brandFile);
    }

    public String findBrandInFile(long id) {
        return findInFile(id, brandFile);
    }
}
