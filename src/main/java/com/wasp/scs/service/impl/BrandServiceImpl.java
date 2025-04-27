package com.wasp.scs.service.impl;

import com.wasp.scs.constant.AppConstant;
import com.wasp.scs.entity.Brand;
import com.wasp.scs.exception.BrandException;
import com.wasp.scs.service.BrandService;
import com.wasp.scs.service.counter.CounterService;
import com.wasp.scs.service.counter.impl.BrandCounterImpl;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.util.LoggerUtil;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;
    private final CounterService counterService = new BrandCounterImpl();

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Brand brand) {
        try {
            isValidBrand(brand);
            int counter = counterService.getNextId(); // set id for brand?
            if (counter > AppConstant.ERROR_VALUE) {
                brand.setId(counter);
                repository.create(brand);
            } else {
                throw new BrandException(String.format("%s %s", "Counter value must be greater than", AppConstant.ERROR_VALUE));
            }
        } catch (BrandException exception) {
            LoggerUtil.loggErrors(exception);
            throw exception;
        }
    }

    @Override
    public void delete(Brand brand) {
        isValidBrand(brand);
        repository.delete(brand);
    }

    private void isValidBrand(Brand brand) {
        if (brand == null) {
            throw new BrandException("Brand cannot be NULL.");
        }
        if (brand.getName().isEmpty()) {
            throw new BrandException("Brand name cannot be EMPTY.");
        }
    }

    @Override
    public void update(Brand brand) {
        try {
            isValidBrand(brand);
            Brand oldBrand = repository.findById(brand.getId());
            oldBrand.setName(brand.getName());
            repository.update(oldBrand);
        } catch (BrandException exception) {
            LoggerUtil.loggErrors(exception);
            throw exception;
        }
    }

    @Override
    public List<Brand> listBrand() {
        return repository.listBrand();
    }
}
