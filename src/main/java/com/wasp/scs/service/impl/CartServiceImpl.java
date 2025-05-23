package com.wasp.scs.service.impl;

import com.wasp.scs.entity.Product;
import com.wasp.scs.enums.ActionStatus;
import com.wasp.scs.repository.CartRepository;
import com.wasp.scs.repository.impl.CartRepositoryImpl;
import com.wasp.scs.service.CartService;
import com.wasp.scs.service.validator.ValidatorService;

import java.util.List;

public class CartServiceImpl implements CartService, ValidatorService<Product> {

    private final CartRepository repository = new CartRepositoryImpl();

    @Override
    public ActionStatus addProduct(Product product) {
        if (!isValid(product)) {
            return ActionStatus.INVALID_INPUT;
        }
        if (repository.addProduct(product)) {
            return ActionStatus.SUCCESS;
        }
        return ActionStatus.FAILED;
    }

    @Override
    public ActionStatus removeProduct(long id) {
        return null;
    }

    @Override
    public ActionStatus clearCart(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
