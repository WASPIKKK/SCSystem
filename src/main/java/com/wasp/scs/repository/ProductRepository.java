package com.wasp.scs.repository;

import com.wasp.scs.entity.Product;
import com.wasp.scs.entity.Supplier;

import java.util.List;

public interface ProductRepository {

    boolean create(Product product);

    boolean delete(Long id);

    Supplier findById(Long id);

    boolean update(Long id);

    List<Supplier> listProduct();
}
