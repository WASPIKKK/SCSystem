package com.wasp.scs.service;

import com.wasp.scs.entity.Brand;

import java.util.List;

public interface BrandService {

    void create(Brand brand);

    void delete(Brand brand);

    void update(Brand brand);

    List<Brand> listBrand();
}
