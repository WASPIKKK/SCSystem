package com.wasp.scs.util;

import java.io.File;

public final class ConstantUtil {

    public static final String NEW_LINE = "\n";
    public static final String SEPARATOR = ";";
    public static final String TITLE = "ID" + SEPARATOR + "NAME" + NEW_LINE;
    public static final File TEMP_FILE = new File("src/main/resource/error/temp.txt");
    public static final File SUPPLIER_FILE = new File("src/main/resource/data/listSupplier.csv");
    public static final File PRODUCT_FILE = new File("src/main/resource/data/listProduct.csv");
    public static final File BRAND_FILE = new File("src/main/resource/data/listBrand.csv");

    private ConstantUtil() {
    }
}
