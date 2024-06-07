package stockexchange;

import java.util.Date;

public class Order {
    private String orderId;
    private User user;
    private String stockSymbol;
    private int quantity;
    private double price;
    private OrderType orderType;
    private Date timestamp;

    public Order(String orderId, User user, String stockSymbol, int quantity, double price, OrderType orderType) {
        this.orderId = orderId;
        this.user = user;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
        this.timestamp = new Date();
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
