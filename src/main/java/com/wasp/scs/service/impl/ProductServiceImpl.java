package com.wasp.scs.service.impl;

import com.wasp.scs.db.counter.ProductCounter;
import com.wasp.scs.db.counter.base.CounterManager;
import com.wasp.scs.entity.Brand;
import com.wasp.scs.entity.Entity;
import com.wasp.scs.entity.Product;
import com.wasp.scs.entity.Supplier;
import com.wasp.scs.enums.ActionStatus;
import com.wasp.scs.repository.ProductRepository;
import com.wasp.scs.repository.impl.ProductRepositoryImpl;
import com.wasp.scs.service.ProductService;
import com.wasp.scs.service.validator.ValidatorService;

import java.util.List;

public class ProductServiceImpl implements ProductService, ValidatorService<Entity> {

    private final ProductRepository repository = new ProductRepositoryImpl();
    private final CounterManager counterManager = new ProductCounter();

    @Override
    public ActionStatus create(Product product, Brand brand, Supplier supplier) {
        if (isValid(brand) && isValid(supplier) && isValid(product)) {
            if (counterManager.generateNextId()) {
                int id = counterManager.getCurrentId();
                product.setId(id);
                product.setBrand(brand);
                product.setSupplier(supplier);
                if (repository.create(product)) {
                    return ActionStatus.SUCCESS;
                } else {
                    counterManager.restorePreviousId();
                }
            }
            return ActionStatus.FAILED;
        }
        return ActionStatus.INVALID_INPUT;
    }


    @Override
    public ActionStatus delete(Long id) {
        return null;
    }

    @Override
    public ActionStatus update(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public boolean isValid(Entity entity) {
        return false;
    }
}
