package com.wasp.scs.service;

import com.wasp.scs.entity.Supplier;
import com.wasp.scs.enums.ActionStatus;

import java.util.List;

public interface SupplierService {

    ActionStatus create(Supplier supplier);

    ActionStatus delete(Supplier supplier);

    ActionStatus update(Supplier supplier);

    List<Supplier> getAllSupplier();
}
