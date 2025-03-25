package com.wasp.scs.repository.impl;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.exception.RepositoryException;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.util.ConstantUtil;
import com.wasp.scs.util.CsvUtil;

import java.util.ArrayList;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepository {

    private final CsvUtil csvUtils;

    public BrandRepositoryImpl(CsvUtil csvUtils) {
        this.csvUtils = csvUtils;
    }

    @Override
    public void create(Brand brand) {
        if (!csvUtils.write(brand.toString())) {
            throw new RepositoryException("Failed to create brand in CSV, check log");
        }
    }

    @Override
    public void delete(Brand brand) {
        if (!csvUtils.delete(brand.toString())) {
            throw new RepositoryException("Failed to delete brand in CSV, check log");
        }
    }

    @Override
    public void updateByName(Brand brand) {
        List<Brand> brandList = fileToListBrand();
        for (Brand tempBrand : brandList) {
            if (tempBrand.getName().equalsIgnoreCase(brand.getName())) {
                tempBrand.setName(brand.getName());
            }
        }
        csvUtils.update(listBrandToString(brandList));
    }


    @Override
    public List<Brand> findBrandByName(Brand brand) {
        List<Brand> findBrand = new ArrayList<>();
        for (Brand tempBrand : fileToListBrand()) {
            if (tempBrand.getName().equalsIgnoreCase(brand.getName())) {
                findBrand.add(tempBrand);
            }
        }
        return findBrand;
    }

    public List<Brand> fileToListBrand() {
        List<String> listBrandInString = csvUtils.readData(ConstantUtil.BRAND_FILE);
        List<Brand> brands = new ArrayList<>();
        for (String temp : listBrandInString) {
            String[] tempArray = temp.split(";");
            Brand brand1 = new Brand(tempArray[1]);
            brand1.setId(Integer.parseInt(tempArray[0]));
            brands.add(brand1);
        }
        return brands;
    }


    private List<String> listBrandToString(List<Brand> list) {
        List<String> stringList = new ArrayList<>(list.size());
        for (Brand brand : list) {
            stringList.add(brand.toString());
        }
        return stringList;
    }


}
