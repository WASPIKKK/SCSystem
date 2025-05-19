package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Product;
import com.wasp.scs.entity.Supplier;
import com.wasp.scs.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Supplier findById(Long id) {
        return null;
    }

    @Override
    public boolean update(Long id) {
        return false;
    }

    @Override
    public List<Supplier> listProduct() {
        return List.of();
    }

}
