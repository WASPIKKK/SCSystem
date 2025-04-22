package com.wasp.scs.entity;

public class Product extends Entity{

    private Brand brand;
    private Supplier supplier;

    public Product(String name) {
       super(name);
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
