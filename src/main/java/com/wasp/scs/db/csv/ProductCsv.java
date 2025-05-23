package com.wasp.scs.db.csv;

import com.wasp.scs.constant.StorageConstant;
import com.wasp.scs.db.csv.base.EntityCsvManager;
import com.wasp.scs.entity.Product;

import java.io.File;
import java.util.List;

public class ProductCsv extends EntityCsvManager {

    private static final String FILE_NAME = "product.csv";
    private static final String DIR_PATH = String.format("%s/%s/%s/%s",
            StorageConstant.GENERAL_DIR,
            StorageConstant.CATALOG_DIR, "product",
            StorageConstant.CSV_DIR);
    private final File productFile;

    public ProductCsv() {
        this.productFile = prepareDirAndFile(DIR_PATH, FILE_NAME);
    }

    @Override
    protected String getTitle() {
        return String.format("ID%sNAME%sBRAND%sSUPPLIER%s", SEPARATOR, SEPARATOR, SEPARATOR, NEW_LINE);
    }

    public boolean writeProductToFile(String entity) {
        return writeToFile(entity, productFile);
    }

    public List<String> readProductFromFile() {
        return readFromFile(productFile);
    }

    public boolean deleteProductFromFile(long id) {
        return deleteFromFile(id, productFile);
    }

    public boolean rewriteSupplierToFile(String product) {
        return rewriteToFile(product, productFile);
    }

    public String findProductInFile(long id) {
        return findInFile(id, productFile);
    }
}
