package ecommerce;

import java.util.List;

public class Order {
    private String id;

    private User user;

    private OrderStatus orderStatus = OrderStatus.PENDING;

    private List<OrderItem> orderItems;

    public Order(String id, User user,  List<OrderItem> orderItems) {
        this.id = id;
        this.user = user;
        this.orderItems = orderItems;
    }

    public double totalAmount() {
        return orderItems.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public OrderStatus getOrderStatus(){
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    public User getUser(){
        return user;
    }

    public String getId() {
        return id;
    }
}
