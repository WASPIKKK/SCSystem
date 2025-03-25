package com.wasp.scs.entity;

public final class Brand extends Entity{

    private String name;
    private int id;

    public Brand(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ";" + name;
    }
}
