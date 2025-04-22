package com.wasp.scs.repository;

import com.wasp.scs.entity.Brand;

public interface BrandRepository {

    void create(Brand brand);

    void delete(Brand brand);

    Brand findById(Long id);

    void update(Brand brand);

}
