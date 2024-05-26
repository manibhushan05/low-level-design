package ecommerce;

import java.util.UUID;

public class Product {
    private String id;

    private String name;

    private double price;

    private int quantity;

    public Product(String name, double price, int quantity) {
        this.id = UUID.randomUUID().toString();
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

    public String getName() {
        return name;
    }

    public synchronized boolean isAvailable(int quantity) {
        return this.quantity >= quantity;
    }

    public synchronized void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
