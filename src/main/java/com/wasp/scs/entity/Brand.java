package com.wasp.scs.entity;

import com.wasp.scs.entity.helper.ProductUpdater;

public class Brand extends Entity implements ProductUpdater {

    public Brand(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getId() + ";" + getName();
    }

    @Override
    public void productUpdate(Product product) {
        product.setBrand(this);
    }
}
