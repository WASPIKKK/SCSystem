package com.wasp.scs.repository;

import com.wasp.scs.entity.Brand;

import java.util.List;

public interface BrandRepository {

    boolean create(Brand brand);

    boolean delete(long id);

    Brand findById(long id);

    boolean update(Brand brand);

    List<Brand> listBrand();

}
