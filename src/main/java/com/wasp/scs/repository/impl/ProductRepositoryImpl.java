package com.wasp.scs.repository.impl;

import com.wasp.scs.db.csv.ProductCsv;
import com.wasp.scs.entity.Product;
import com.wasp.scs.mapper.ProductMapper;
import com.wasp.scs.mapper.base.EntityMapper;
import com.wasp.scs.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCsv productCsv = new ProductCsv();
    private final EntityMapper<Product, ProductCsv> mapper = new ProductMapper();

    @Override
    public boolean create(Product product) {
        return productCsv.writeProductToFile(product.toString());
    }

    @Override
    public boolean delete(long id) {
        return productCsv.deleteProductFromFile(id);
    }

    @Override
    public Product findById(long id) {
        String tempProduct = productCsv.findProductInFile(id);
        if (tempProduct != null) {
            return mapper.mapToEntity(tempProduct);
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        return productCsv.rewriteSupplierToFile(product.toString());
    }

    @Override
    public List<Product> listProduct() {
        return mapper.mapToList(productCsv);
    }

}
