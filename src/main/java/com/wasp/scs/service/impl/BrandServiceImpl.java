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
        if (isValid(brand)) {
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
        return ActionStatus.INVALID_INPUT;
    }

    @Override
    public ActionStatus delete(Brand brand) {
        if (isValid(brand)) {
            if (repository.delete(brand)) {
                return ActionStatus.SUCCESS;
            }
            return ActionStatus.FAILED;
        }
        return ActionStatus.INVALID_INPUT;
    }

    @Override
    public ActionStatus update(Brand brand) {
        Brand newBrand = repository.findById(brand.getId());
        if (isValid(newBrand)) {
            newBrand.setName(brand.getName());
            if (repository.update(newBrand)) {
                return ActionStatus.SUCCESS;
            }
            return ActionStatus.FAILED;
        }
        return ActionStatus.INVALID_INPUT;
    }

    @Override
    public List<Brand> getAllBrands() {
        return repository.listBrand();
    }

/*    private boolean isValidBrand(Brand brand) {
        return brand != null && brand.getName() != null && !brand.getName().isEmpty();
    }*/

    @Override
    public boolean isValid(Brand brand) {
        return brand != null && brand.getName() != null && !brand.getName().isEmpty();
    }
}
