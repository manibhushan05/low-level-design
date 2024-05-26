package ecommerce;

import java.util.*;

public class ShoppingCart {
    private User user;

    private final Map<String, OrderItem> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        String productId = product.getId();
        if (items.containsKey(productId)) {
            OrderItem item = items.get(productId);
            quantity += item.getQuantity();
        }
        items.put(productId, new OrderItem(UUID.randomUUID().toString(), quantity, product));
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public void updateItemQuantity(String productId, int quantity) {
        OrderItem item = items.get(productId);
        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        }
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public void clearItems() {
        items.clear();
    }
}
