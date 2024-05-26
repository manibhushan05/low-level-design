package ecommerce;

public class OrderItem {
    private String id;

    private int quantity;

    private double price;

    private Product product;

    public OrderItem(String id, int quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.price = product.getPrice();
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
