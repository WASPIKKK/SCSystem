package com.wasp.scs.entity;

import java.util.List;

public final class Cart {

    private List<Product> productList;

    public Cart() {
    }

    public Cart(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
