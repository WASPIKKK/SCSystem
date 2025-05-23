package com.wasp.scs.service;

import com.wasp.scs.entity.Supplier;
import com.wasp.scs.enums.ActionStatus;

import java.util.List;

public interface SupplierService {

    ActionStatus create(Supplier supplier);

    ActionStatus delete(long id);

    ActionStatus update(long id, String name);

    List<Supplier> getAllSupplier();
}
