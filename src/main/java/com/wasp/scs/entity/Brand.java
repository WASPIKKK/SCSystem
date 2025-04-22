package com.wasp.scs.entity;

public class Brand extends Entity{

    public Brand(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getId() + ";" + getName();
    }
}
