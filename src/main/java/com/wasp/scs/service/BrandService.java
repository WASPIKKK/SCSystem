package com.wasp.scs.service;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.enums.ActionStatus;

import java.util.List;

public interface BrandService {

    ActionStatus create(Brand brand);

    ActionStatus delete(long id);

    ActionStatus update(long id, String name);

    List<Brand> getAllBrands();
}
