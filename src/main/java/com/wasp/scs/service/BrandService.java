package com.wasp.scs.service;

import com.wasp.scs.constant.AppConstant;
import com.wasp.scs.entity.Brand;
import com.wasp.scs.exception.BrandException;
import com.wasp.scs.file.FileStorage;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.util.LoggerUtil;
import com.wasp.scs.util.SequenceUtil;

public class BrandService {

    private final BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }
    public void createBrand(Brand brand) {
        try {
            isValidBrand(brand);
            int counter = SequenceUtil.readAndUpdateCounter(FileStorage.BRAND_COUNT, FileStorage.TEMP_FILE);
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

    public void deleteBrand(Brand brand) {
        isValidBrand(brand);
        repository.delete(brand);
    }

    private void isValidBrand(Brand brand) {
        if (brand == null) {
            throw new BrandException("Brand cannot be NULL.");
        }
        if (brand.getName().isEmpty()) {
            throw new BrandException("Brand name cannot be empty.");
        }
    }

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
}
