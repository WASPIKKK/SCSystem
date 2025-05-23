package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Product;
import com.wasp.scs.repository.CartRepository;

import java.util.List;

public class CartRepositoryImpl implements CartRepository {
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean removeProduct(long id) {
        return false;
    }

    @Override
    public boolean clearCart(long id) {
        return false;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
