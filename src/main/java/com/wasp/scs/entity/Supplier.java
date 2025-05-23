package com.wasp.scs.entity;

import com.wasp.scs.entity.helper.ProductUpdater;

public class Supplier extends Entity implements ProductUpdater {

    public Supplier(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getId() + ";" + getName();
    }

    @Override
    public void productUpdate(Product product) {
        product.setSupplier(this);
    }
}
