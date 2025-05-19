package com.wasp.scs.mapper;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.db.csv.BrandCsv;
import com.wasp.scs.mapper.base.EntityMapper;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper extends EntityMapper<Brand, BrandCsv> {

    @Override
    public List<Brand> mapToList(BrandCsv brandCsv) {
        List<String> listBrandInString = brandCsv.readBrandFromFile();
        List<Brand> listBrand = new ArrayList<>();

        for (String temp : listBrandInString) {
            Brand tempBrand = mapToEntity(temp);
            listBrand.add(tempBrand);
        }

        return listBrand;
    }

    @Override
    public Brand mapToEntity(String stringBrand) {
        String[] arrayBrand = stringBrand.split(";", 2);
        Brand newBrand = new Brand(arrayBrand[1]);
        newBrand.setId(Integer.parseInt(arrayBrand[0]));
        return newBrand;
    }
}
