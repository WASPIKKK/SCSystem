package com.wasp.scs.service;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.entity.Product;
import com.wasp.scs.entity.Supplier;
import com.wasp.scs.enums.ActionStatus;

import java.util.List;

public interface ProductService {

    ActionStatus create(Product product, Brand brand, Supplier supplier);

    ActionStatus delete(Long id);

    ActionStatus update(Long id);

    List<Product> getAllProduct();
}
