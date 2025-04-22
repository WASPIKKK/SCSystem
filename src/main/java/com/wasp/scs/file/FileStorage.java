package com.wasp.scs.file;

import java.io.File;

public final class FileStorage {

    private FileStorage() {
    }

    public static final File TEMP_FILE = new File("src/main/resource/counter/temp.txt");
    public static final File BRAND_COUNT = new File("src/main/resource/counter/brandCounter.txt");
    public static final File SUPPLIER_COUNT = new File("src/main/resource/counter/supplierCounter.txt");
    public static final File PRODUCT_COUNT = new File("src/main/resource/counter/productCounter.txt");
    public static final File BRAND_FILE = new File("src/main/resource/data/listBrand.csv");
    public static final File LOGS = new File("src/main/resource/error/logs.txt");
}
