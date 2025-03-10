package product;

public class Supplier {
    private String name;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void changeNameSupplier(String name) {
        this.name = name;
    }

}
