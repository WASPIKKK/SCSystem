package com.wasp.scs.repository;

import com.wasp.scs.entity.Product;

import java.util.List;

public interface CartRepository {

    boolean addProduct(Product product);

    boolean removeProduct(long id);

    boolean clearCart(long id);

    List<Product> getAllProduct();
}
