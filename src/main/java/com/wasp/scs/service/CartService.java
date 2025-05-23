package com.wasp.scs.service;

import com.wasp.scs.entity.Product;
import com.wasp.scs.enums.ActionStatus;

import java.util.List;

public interface CartService {

    ActionStatus addProduct(Product product);

    ActionStatus removeProduct(long id);

    ActionStatus clearCart(long id);

    List<Product> getAllProduct();
}
