package ecommerce;

public class Product {
    private String id;

    private String name;

    private double price;

    private long quantity;

    public Product(String id, String name, double price, long quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
