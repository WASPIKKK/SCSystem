package com.wasp.scs.mapper;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.util.csv.CsvUtil;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper {

    private BrandMapper() {
    }

    public static List<Brand> fileToListBrand(CsvUtil csvUtil) {
        List<String> listBrandInString = csvUtil.readFromFile();
        List<Brand> listBrands = new ArrayList<>();
        for (String temp : listBrandInString) {
            Brand tempBrand = stringToBrand(temp);
            listBrands.add(tempBrand);
        }
        return listBrands;
    }


    public static List<String> listBrandToString(List<Brand> list) {
        List<String> stringList = new ArrayList<>(list.size());
        for (Brand brand : list) {
            stringList.add(brand.toString());
        }
        return stringList;
    }


    public static Brand stringToBrand(String stringBrand) {
        String[] arrayBrand = stringBrand.split(";", 2);
        Brand newBrand = new Brand(arrayBrand[1]);
        newBrand.setId(Integer.parseInt(arrayBrand[0]));
        return newBrand;
    }

}
