package product;

import core.Store;

import java.time.LocalDate;

/// todo
/// добавить еще один магазин(учесть, если при переносе в другой магазин, то у него будет там другая айди, сотв id не final должен)

public class Product {
    private static int countProducts;
    private final int id;
    private String name;
    private Brand brand;
    private Supplier supplier;
    private LocalDate date;
    private Store store;

    public Product(Store store, String nameProduct, Brand brand, Supplier supplier, LocalDate date) {
        this.store = store;
        this.id = ++countProducts;
        this.name = nameProduct;
        this.brand = brand;
        this.supplier = supplier;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
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

    public static int getCountProducts() {
        return countProducts;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "store="+store.getNameStore()+
                ", id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand.getName() +
                ", supplier=" + supplier.getName() +
                ", date=" + date +
                '}';
    }
}
