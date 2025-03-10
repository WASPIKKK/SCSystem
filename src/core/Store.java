package core;

import product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    // TODO:
    // вынести лист продуктов в другой класс, он тут не в тему.
    private String nameStore;
    private final Operation operation;
    private Map<Integer, Product> listProduct;

    public Store(String nameStore) {
        this.nameStore = nameStore;
        this.operation = new Operation(this);
        this.listProduct = new HashMap<>();
    }

    public String getNameStore() {
        return nameStore;
    }

    public Operation useOperation() {
        return operation;
    }

    public void changeNameStore(String newName) {
        this.nameStore = newName;
    }

    public Map<Integer, Product> getListProduct() {
        if (listProduct == null) {
            listProduct = new HashMap<>();
        }
        return listProduct;
    }

    public List<Integer> getListId() {
        return new ArrayList<>(listProduct.keySet());
    }


}
