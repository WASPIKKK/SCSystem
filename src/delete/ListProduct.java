package delete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListProduct {
    private final List<String> listProduct = new ArrayList<>();
    private final List<Integer> idProducts = new ArrayList<>();
    private int id = 1;

    private Map<Integer, String> newListProduct = new HashMap<>();


    public List<String> getProducts() {
        return listProduct;
    }

    public List<Integer> getIdList() {
        return idProducts;
    }

    public int getId() {
        return id;
    }

    public void addIdForProduct() {
        idProducts.add(id++);
    }

    public void removeId(Integer id) {
        idProducts.remove(id);
        listProduct.remove(id - 1);
    }

    public Map<Integer, String> getNewListProduct() {
        return newListProduct;
    }

    public void setNewListProduct(Map<Integer, String> newListProduct) {
        this.newListProduct = newListProduct;
    }
}
