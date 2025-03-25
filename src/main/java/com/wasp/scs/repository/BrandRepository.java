package com.wasp.scs.repository;

import com.wasp.scs.entity.Brand;

import java.util.List;

public interface BrandRepository {

    void create(Brand brand);

    void updateByName(Brand brand);

    List<Brand> findBrandByName(Brand brand);

    void delete(Brand brand);


}
