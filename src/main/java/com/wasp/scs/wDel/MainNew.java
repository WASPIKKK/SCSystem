package com.wasp.scs.wDel;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.repository.BrandRepository;
import com.wasp.scs.repository.impl.BrandRepositoryImpl;
import com.wasp.scs.service.BrandService;
import com.wasp.scs.util.csv.BrandCsv;
import com.wasp.scs.util.csv.CsvUtil;

public class MainNew {

    public static void main(String[] args) {
        CsvUtil csvUtil = new BrandCsv();
        BrandRepository repository = new BrandRepositoryImpl(csvUtil);
        BrandService service = new BrandService(repository);
        Brand brand = null;
        service.createBrand(brand);


    }
}

