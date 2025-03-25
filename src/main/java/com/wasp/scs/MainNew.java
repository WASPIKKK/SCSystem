package com.wasp.scs;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.entity.Supplier;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.repository.impl.BrandRepositoryImpl;
import com.wasp.scs.repository.impl.SupplierRepositoryImpl;
import com.wasp.scs.service.BrandService;
import com.wasp.scs.util.BrandCsvUtil;
import com.wasp.scs.util.CsvUtil;

import java.util.ArrayList;
import java.util.List;


public class MainNew {

    public static void main(String[] args) {

        CsvUtil csvUtil = new BrandCsvUtil();
        BrandRepositoryImpl repository = new BrandRepositoryImpl(csvUtil);
        BrandService service = new BrandService(repository);
        Brand brand = new Brand("wasp");
        Brand brand2 = new Brand("gesha");
        Brand brand3 = new Brand("wasp5");


        List<Brand> brands = new ArrayList<>();
        brands.add(brand2);
        brands.add(brand);
        brands.add(brand3);
        System.out.println(brands);

/*        List<String> brandsToString = new ArrayList<>(brands.size());
        for (Brand brand1 : brands) {
            brandsToString.add(brand1.toString());
        }*/

        List<Brand> brandList = repository.fileToListBrand();
        System.out.println(brandList);

    }
}
