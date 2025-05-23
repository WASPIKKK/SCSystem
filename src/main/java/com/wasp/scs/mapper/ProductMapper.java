package com.wasp.scs.mapper;

import com.wasp.scs.db.csv.BrandCsv;
import com.wasp.scs.db.csv.ProductCsv;
import com.wasp.scs.entity.Product;
import com.wasp.scs.entity.Product;
import com.wasp.scs.mapper.base.EntityMapper;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper  extends EntityMapper<Product, ProductCsv> {

    @Override
    public List<Product> mapToList(ProductCsv brandCsv) {
        List<String> listProductInString = brandCsv.readProductFromFile();
        List<Product> listProduct = new ArrayList<>();

        for (String temp : listProductInString) {
            Product tempProduct = mapToEntity(temp);
            listProduct.add(tempProduct);
        }

        return listProduct;
    }

    @Override
    public Product mapToEntity(String stringBrand) {
        String[] arrayProduct = stringBrand.split(";", 2);
        Product newProduct = new Product(arrayProduct[1]);
        newProduct.setId(Integer.parseInt(arrayProduct[0]));
        return newProduct;
    }
}
