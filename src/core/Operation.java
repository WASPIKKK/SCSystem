package core;

import logs.DataStorage;
import product.Brand;
import product.Product;
import product.Supplier;

import java.time.LocalDate;
import java.util.List;

// todo сделать поиск по определенным айди, тоесть я бахнул список айди и дальше я вижу эти товары
public class Operation {
    private final DataStorage dataStorage;
    private final Store store;

    public Operation(Store store) {
        this.store = store;
        this.dataStorage = new DataStorage();
    }

    public void addProduct(Product product) {
        if (product != null) {
            dataStorage.checkWithFiles(List.of(product));
            store.getListProduct().put(product.getId(), product);
            dataStorage.writeToFile(product);
        }
    }

    //todo сделать удание не только по айди, а по списку обьктов Product
    //unsafe
/* public final <T> void removeProduct(T... listProduct) {
        if (listProduct.length == 0) return;
        if (listProduct.length != 1) {
            for (T idOrProduct : listProduct) {
                store.getListProduct().remove(idOrProduct);
            }
        } else {
            store.getListProduct().remove(listProduct[0]);
        }
    }*/

    public <T> void removeProduct(List<T> listIdOrProducts) {
        if (listIdOrProducts.isEmpty()) return;
        if (listIdOrProducts.get(0) instanceof Brand || listIdOrProducts.get(0) instanceof Supplier) return;
        for (T tempObj : listIdOrProducts) {
            store.getListProduct().remove(tempObj);
        }
        dataStorage.removeWithFileLast(listIdOrProducts);
    }


    public <T> List<Product> search(T somethingSearch) {
        return store.getListProduct().values().stream().filter(element -> {
            if (somethingSearch instanceof Product) {
                return element.getName().equalsIgnoreCase(((Product) somethingSearch).getName());
            } else if (somethingSearch instanceof Brand) {
                return element.getBrand().getName().equalsIgnoreCase(((Brand) somethingSearch).getName());
            } else if (somethingSearch instanceof Supplier) {
                return element.getSupplier().getName().equalsIgnoreCase(((Supplier) somethingSearch).getName());
            } else if (somethingSearch instanceof LocalDate) {
                return element.getDate().isAfter((LocalDate) somethingSearch);
            } else {
                return false;
            }
        }).toList();
    }



/*    public List<Product> searchOnProductBrand(Brands brands) {
        return store.getListProduct().values().stream().filter(element -> element.getBrand().getName().equalsIgnoreCase(brands.getName())).toList();
    }

    public List<Product> searchOnProductName(Product product) {
        return store.getListProduct().values().stream().filter(element -> element.getName().equalsIgnoreCase(product.getName())).toList();
    }

    public List<Product> searchOnProductSupplier(Supplier supplier) {
        return store.getListProduct().values().stream().filter(element -> element.getSupplier().getName().equalsIgnoreCase(supplier.getName())).toList();
    }

    public List<Product> searchOnDate(LocalDate date) {
        return store.getListProduct().values().stream().filter(element -> element.getDate().isAfter(date)).toList();
    }*/
}
