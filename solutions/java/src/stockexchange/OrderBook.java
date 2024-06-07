package stockexchange;

import java.util.*;

public class OrderBook {
    private String stockSymbol;
    private PriorityQueue<Order> buyOrders;
    private PriorityQueue<Order> sellOrders;

    public OrderBook(String stockSymbol) {
        this.stockSymbol = stockSymbol;
        this.buyOrders = new PriorityQueue<>(Comparator.comparing(Order::getPrice).reversed().thenComparing(Order::getTimestamp));
        this.sellOrders = new PriorityQueue<>(Comparator.comparing(Order::getPrice).thenComparing(Order::getTimestamp));
    }

    public void addOrder(Order order) {
        if (order.getOrderType() == OrderType.BUY) {
            buyOrders.add(order);
        } else {
            sellOrders.add(order);
        }
    }

    public boolean removeOrder(String orderId) {
        return buyOrders.removeIf(order -> order.getOrderId().equals(orderId)) ||
                sellOrders.removeIf(order -> order.getOrderId().equals(orderId));
    }

    public Order getBestBuyOrder() {
        return buyOrders.peek();
    }

    public Order getBestSellOrder() {
        return sellOrders.peek();
    }

    public List<Trade> matchOrders() {
        List<Trade> trades = new ArrayList<>();
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            Order buyOrder = buyOrders.peek();
            Order sellOrder = sellOrders.peek();
            if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                int quantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
                double price = (buyOrder.getTimestamp().before(sellOrder.getTimestamp())) ? buyOrder.getPrice() : sellOrder.getPrice();

                Trade trade = new Trade(UUID.randomUUID().toString(), buyOrder, sellOrder, quantity, price, new Date());
                trades.add(trade);

                if (buyOrder.getQuantity() > quantity) {
                    buyOrder.setQuantity(buyOrder.getQuantity() - quantity);
                } else {
                    buyOrders.poll();
                }

                if (sellOrder.getQuantity() > quantity) {
                    sellOrder.setQuantity(sellOrder.getQuantity() - quantity);
                } else {
                    sellOrders.poll();
                }
            } else {
                break;
            }
        }
        return trades;
    }
}
