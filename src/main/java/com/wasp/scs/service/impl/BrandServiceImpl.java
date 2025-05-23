package com.wasp.scs.service.impl;

import com.wasp.scs.db.counter.base.CounterManager;
import com.wasp.scs.entity.Brand;
import com.wasp.scs.enums.ActionStatus;
import com.wasp.scs.repository.impl.BrandRepositoryImpl;
import com.wasp.scs.service.BrandService;
import com.wasp.scs.db.counter.BrandCounter;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.service.validator.ValidatorService;

import java.util.List;

public class BrandServiceImpl implements BrandService, ValidatorService<Brand> {

    private final BrandRepository repository = new BrandRepositoryImpl();
    private final CounterManager counterManager = new BrandCounter();

    @Override
    public ActionStatus create(Brand brand) {
        if(!isValid(brand)){
            return ActionStatus.INVALID_INPUT;
        }

        if (counterManager.generateNextId()) {
            int id = counterManager.getCurrentId();
            brand.setId(id);
            if (repository.create(brand)) {
                return ActionStatus.SUCCESS;
            } else {
                counterManager.restorePreviousId();
            }
        }

        return ActionStatus.FAILED;
    }

    @Override
    public ActionStatus delete(long id) {
        Brand brand = repository.findById(id);

        if (!isValid(brand)) {
            return ActionStatus.INVALID_INPUT;
        }

        if(repository.delete(id)){
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    @Override
    public ActionStatus update(long id, String name) {
        Brand brand = repository.findById(id);

        if (!isValid(brand)) {
            return ActionStatus.INVALID_INPUT;
        }

        brand.setName(name);
        if (repository.update(brand)) {
            return ActionStatus.SUCCESS;
        }

        return ActionStatus.FAILED;
    }

    @Override
    public List<Brand> getAllBrands() {
        return repository.listBrand();
    }
}
