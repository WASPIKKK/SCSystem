package com.wasp.scs.service.impl;

import com.wasp.scs.db.counter.ProductCounter;
import com.wasp.scs.db.counter.base.CounterManager;
import com.wasp.scs.entity.Brand;
import com.wasp.scs.entity.Entity;
import com.wasp.scs.entity.Product;
import com.wasp.scs.entity.Supplier;
import com.wasp.scs.entity.helper.ProductUpdater;
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
        if (!isValid(brand) || !isValid(supplier) || !isValid(product)) {
            return ActionStatus.INVALID_INPUT;
        }

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


    @Override
    public ActionStatus delete(long id) {
        Product product = repository.findById(id);

        if (!isValid(product)) {
            return ActionStatus.INVALID_INPUT;
        }

        if(repository.delete(id)){
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    @Override
    public ActionStatus update(long id, String name) {
        Product product = repository.findById(id);

        if (!isValid(product)) {
            return ActionStatus.INVALID_INPUT;
        }

        product.setName(name);
        if (repository.update(product)) {
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    public ActionStatus update(long id, Entity entity) {
        Product product = repository.findById(id);

        if (!isValid(entity) || !isValid(product)) {
            return ActionStatus.INVALID_INPUT;
        }

        if (entity instanceof ProductUpdater) {
            ((ProductUpdater) entity).productUpdate(product);
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.listProduct();
    }

}
