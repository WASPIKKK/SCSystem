package com.wasp.scs.service;

import com.wasp.scs.entity.Brand;
import com.wasp.scs.enums.ActionStatus;

import java.util.List;

public interface BrandService {

    ActionStatus create(Brand brand);

    ActionStatus delete(Brand brand);

    ActionStatus update(Brand brand);

    List<Brand> getAllBrands();
}
