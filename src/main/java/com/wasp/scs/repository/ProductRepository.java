package com.wasp.scs.repository;

import com.wasp.scs.entity.Product;

import java.util.List;

public interface ProductRepository {

    boolean create(Product product);

    boolean delete(long id);

    Product findById(long id);

    boolean update(Product product);

    List<Product> listProduct();
}
