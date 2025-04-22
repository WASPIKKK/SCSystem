package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.mapper.BrandMapper;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.util.csv.CsvUtil;

public class BrandRepositoryImpl implements BrandRepository {

    private final CsvUtil csvUtils;

    public BrandRepositoryImpl(CsvUtil csvUtils) {
        this.csvUtils = csvUtils;
    }

    @Override
    public void create(Brand brand) {
        csvUtils.writeToFile(brand.toString());
    }

    @Override
    public void delete(Brand brand) {
        csvUtils.deleteFromFile(brand.toString());
    }

    @Override
    public Brand findById(Long id) {
        String tempBrand = csvUtils.findInFile(id);
        if (tempBrand != null) {
            return BrandMapper.stringToBrand(tempBrand);
        }
        return null;
    }

    @Override
    public void update(Brand brand) {
        csvUtils.rewriteInFile(brand.toString());
    }
}
