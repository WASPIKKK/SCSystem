package com.wasp.scs.file;

import com.wasp.scs.exception.DirectoryCreationException;

import java.io.*;

public class AppStorage {

    private static final String NAME_GENERAL_DIR = "data";
    private static final String NAME_CATALOG_DIR = "catalog";
    private static final String NAME_LOG_DIR = "log";

    private static final String NAME_BRAND_DIR = "brand";
    private static final String NAME_SUPPLIER_DIR = "supplier";
    private static final String NAME_PRODUCT_DIR = "product";

    private static final String NAME_CSV_DIR = "csv";
    private static final String NAME_COUNT_DIR = "count";

    private static final String NAME_CSV_FILE_BRAND = "brand.csv";
    private static final String NAME_CSV_FILE_SUPPLIER = "supplier.csv";
    private static final String NAME_CSV_FILE_PRODUCT = "product.csv";

    private static final String NAME_TEMP_FILE = "file.txt";
    private static final String NAME_COUNT_FILE = "count.txt";

    private static final String NAME_LOG_FILE = "log.txt";

    public static final String NEW_LINE = "\n";
    public static final String SEPARATOR = ";";
    public static final String TITLE = String.format("ID%sNAME%s", SEPARATOR, NEW_LINE);

    private static final File GENERAL_DIR = new File(NAME_GENERAL_DIR);
    private static final File CATALOG_DIR = new File(GENERAL_DIR, NAME_CATALOG_DIR);

    private static final File BRAND_DIR = new File(CATALOG_DIR, NAME_BRAND_DIR);
    private static final File SUPPLIER_DIR = new File(CATALOG_DIR, NAME_SUPPLIER_DIR);
    private static final File PRODUCT_DIR = new File(CATALOG_DIR, NAME_PRODUCT_DIR);

    public static final File CSV_BRAND_DIR = new File(BRAND_DIR, NAME_CSV_DIR);
    public static final File CSV_SUPPLIER_DIR = new File(SUPPLIER_DIR, NAME_CSV_DIR);
    public static final File CSV_PRODUCT_DIR = new File(PRODUCT_DIR, NAME_CSV_DIR);

    public static final File COUNT_BRAND_DIR = new File(BRAND_DIR, NAME_COUNT_DIR);
    public static final File COUNT_SUPPLIER_DIR = new File(SUPPLIER_DIR, NAME_COUNT_DIR);
    public static final File COUNT_PRODUCT_DIR = new File(PRODUCT_DIR, NAME_COUNT_DIR);

    public static final File LOG_DIR = new File(GENERAL_DIR, NAME_LOG_DIR);

    public static final File TEMP_COUNT_FILE_BRAND = new File(COUNT_BRAND_DIR, NAME_TEMP_FILE);
    public static final File TEMP_COUNT_FILE_SUPPLIER = new File(COUNT_SUPPLIER_DIR, NAME_TEMP_FILE);
    public static final File TEMP_COUNT_FILE_PRODUCT = new File(COUNT_PRODUCT_DIR, NAME_TEMP_FILE);

    public static final File COUNT_FILE_BRAND = new File(COUNT_BRAND_DIR, NAME_COUNT_FILE);
    public static final File COUNT_FILE_SUPPLIER = new File(COUNT_SUPPLIER_DIR, NAME_COUNT_FILE);
    public static final File COUNT_FILE_PRODUCT = new File(COUNT_PRODUCT_DIR, NAME_COUNT_FILE);

    public static final File CSV_FILE_BRAND = new File(CSV_BRAND_DIR, NAME_CSV_FILE_BRAND);
    public static final File CSV_FILE_SUPPLIER = new File(CSV_SUPPLIER_DIR, NAME_CSV_FILE_SUPPLIER);
    public static final File CSV_FILE_PRODUCT = new File(CSV_PRODUCT_DIR, NAME_CSV_FILE_PRODUCT);

    public static final File TEMP_CSV_FILE_BRAND = new File(CSV_BRAND_DIR, NAME_TEMP_FILE);
    public static final File TEMP_CSV_FILE_SUPPLIER = new File(CSV_SUPPLIER_DIR, NAME_TEMP_FILE);
    public static final File TEMP_CSV_FILE_PRODUCT = new File(CSV_PRODUCT_DIR, NAME_TEMP_FILE);

    public static final File LOG_FILE = new File(LOG_DIR, NAME_LOG_FILE);


    private AppStorage() {
    }


    public static void initDir() {
        File[] dirs = {
                GENERAL_DIR,
                CATALOG_DIR,
                BRAND_DIR, SUPPLIER_DIR, PRODUCT_DIR,
                CSV_BRAND_DIR, CSV_SUPPLIER_DIR, CSV_PRODUCT_DIR,
                COUNT_BRAND_DIR, COUNT_SUPPLIER_DIR, COUNT_PRODUCT_DIR,
                LOG_DIR
        };

        for (File file : dirs) {
            if (!file.exists()) {
                boolean created = file.mkdirs();
                if (!created) {
                    throw new DirectoryCreationException(String.format("%s { %s }", "Can't create a dir", file.getName()));
                }
            }
        }

    }
}
