package ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class OrderManager {
    private static OrderManager instance;

    private final Map<String, User> users;

    private final Map<String, Product> products;

    private final Map<String, Order> orders;

    private final Map<User, List<Order>> userOrders;

    public OrderManager() {
        this.userOrders = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
        this.products = new ConcurrentHashMap<>();
        this.orders = new ConcurrentHashMap<>();
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            return new OrderManager();
        }
        return instance;
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public List<Product> searchProduct(String keyword) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public synchronized Order placeOrder(User user, ShoppingCart cart, Payment payment) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if (product.isAvailable(quantity)) {
                product.updateQuantity(-quantity);
                orderItems.add(item);
            }
        }
        if (orderItems.isEmpty()) {
            throw new IllegalStateException("No available product in cart");
        }
        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, user, orderItems);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        userOrders.put(user, orderList);
        cart.clearItems();
        if (payment.processPayment(order.totalAmount())) {
            order.setOrderStatus(OrderStatus.PROCESSING);
        } else {
            for (OrderItem item : orderItems) {
                Product product = item.getProduct();
                product.updateQuantity(item.getQuantity());
            }
        }
        return order;
    }
}
