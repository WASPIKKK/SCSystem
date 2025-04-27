package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.file.csv.BrandCsv;
import com.wasp.scs.mapper.EntityMapper;
import com.wasp.scs.mapper.impl.BrandMapper;
import com.wasp.scs.repository.BrandRepository;

import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final BrandCsv brandCsv = new BrandCsv();
    private final EntityMapper<Brand, BrandCsv> mapper = new BrandMapper();

    @Override
    public void create(Brand brand) {
        brandCsv.writeBrandToFile(brand.toString());
    }

    @Override
    public void delete(Brand brand) {
        brandCsv.deleteBrandFromFile(brand.toString());
    }

    @Override
    public Brand findById(Long id) {
        String tempBrand = brandCsv.findBrandInFile(id);
        if (tempBrand != null) {
            return mapper.stringToEntity(tempBrand);
        }
        return null;
    }

    @Override
    public void update(Brand brand) {
        brandCsv.rewriteBrandToFile(brand.toString());
    }

    @Override
    public List<Brand> listBrand() {
        return mapper.fileToListEntity(brandCsv);
    }
}
