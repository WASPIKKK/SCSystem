import core.Store;
import product.Product;
import product.Brand;
import product.Supplier;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("WASP");

        Brand brand = new Brand("Apple");
        Brand brand1 = new Brand("Samsung");

        Supplier supplier = new Supplier("USA");
        Supplier supplier1 = new Supplier("CHN");

        Product product = new Product(store, "Iphone", brand, supplier, LocalDate.now());
        Product product2 = new Product(store, "Iphone", brand1, supplier, LocalDate.now());
        Product product3 = new Product(store, "Samsung", brand1, supplier1, LocalDate.of(2021, 1, 1));
        Product product4 = new Product(store, "Samsung", brand1, supplier1, LocalDate.of(2021, 1, 1));


        store.useOperation().addProduct(product);
        store.useOperation().addProduct(product2);
        store.useOperation().addProduct(product3);

       // store.useOperation().removeProduct(List.of(product3));




    }
}