package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.db.csv.BrandCsv;
import com.wasp.scs.mapper.base.EntityMapper;
import com.wasp.scs.mapper.BrandMapper;
import com.wasp.scs.repository.BrandRepository;

import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final BrandCsv brandCsv = new BrandCsv();
    private final EntityMapper<Brand, BrandCsv> mapper = new BrandMapper();

    @Override
    public boolean create(Brand brand) {
        return brandCsv.writeBrandToFile(brand.toString());
    }

    @Override
    public boolean delete(Brand brand) {
        return brandCsv.deleteBrandFromFile(brand.toString());
    }

    @Override
    public Brand findById(Long id) {
        String tempBrand = brandCsv.findBrandInFile(id);
        if (tempBrand != null) {
            return mapper.mapToEntity(tempBrand);
        }
        return null;
    }

    @Override
    public boolean update(Brand brand) {
        return brandCsv.rewriteBrandToFile(brand.toString());
    }

    @Override
    public List<Brand> listBrand() {
        return mapper.mapToList(brandCsv);
    }
}
