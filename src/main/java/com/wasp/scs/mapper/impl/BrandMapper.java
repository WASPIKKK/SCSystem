package com.wasp.scs.mapper.impl;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.file.csv.BrandCsv;
import com.wasp.scs.mapper.EntityMapper;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper implements EntityMapper<Brand, BrandCsv> {

    @Override
    public List<Brand> fileToListEntity(BrandCsv brandCsv) {
        List<String> listBrandInString = brandCsv.readBrandFromFile();
        List<Brand> listBrand = new ArrayList<>();
        for (String temp : listBrandInString) {
            Brand tempBrand = stringToEntity(temp);
            listBrand.add(tempBrand);
        }
        return listBrand;
    }

    @Override
    public Brand stringToEntity(String stringBrand) {
        String[] arrayBrand = stringBrand.split(";", 2);
        Brand newBrand = new Brand(arrayBrand[1]);
        newBrand.setId(Integer.parseInt(arrayBrand[0]));
        return newBrand;
    }
}
