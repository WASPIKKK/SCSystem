package com.wasp.scs.service;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.exception.RepositoryException;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.util.SequenceUtil;

import java.util.ArrayList;
import java.util.List;

public class BrandService {

    private final BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public void createBrand(Brand brand) {
        if (isValidBrand(brand)) {
            int counter = SequenceUtil.counter(ConstantService.BRAND_COUNT);
            if (counter > -1) {
                brand.setId(counter);
                repository.create(brand);
            }
        } else {
            throw new RepositoryException("can't create brand");
        }
    }

    public void deleteBrand(Brand brand) {
        if (isValidBrand(brand)) {
            repository.delete(brand);
        } else {
            throw new RepositoryException("can't delete brand");
        }
    }

    public void updateBrand(Brand brand, String newName) {
        if (isValidBrand(brand) && !newName.isEmpty()) {
            brand.setName(newName);
            repository.updateByName(brand);
        } else {
            throw new RepositoryException("can't update brand");
        }
    }

    public List<String> listEntity(Brand brand) {
        if (isValidBrand(brand)) {
            // return repository.findBrand(brand);
        }
        return new ArrayList<>();
    }

    private boolean isValidBrand(Brand brand) {
        return brand != null && !brand.getName().isEmpty();
    }

}
