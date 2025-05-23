package com.wasp.scs.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProduct(Product product) {
        this.productList.remove(product);
    }

    public void removeAllProduct() {
        productList.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productList=" + productList +
                '}';
    }
}
