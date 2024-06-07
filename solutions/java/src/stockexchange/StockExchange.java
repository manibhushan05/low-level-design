package stockexchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockExchange {
    private Map<String, OrderBook> orderBooks;

    public StockExchange(List<String> stockSymbols) {
        orderBooks = new HashMap<>();
        for (String symbol : stockSymbols) {
            orderBooks.put(symbol, new OrderBook(symbol));
        }
    }

    public void placeOrder(Order order) {
        OrderBook orderBook = orderBooks.get(order.getStockSymbol());
        if (orderBook != null) {
            orderBook.addOrder(order);
            matchOrders(order.getStockSymbol());
        }
    }

    public void cancelOrder(String orderId) {
        for (OrderBook orderBook : orderBooks.values()) {
            if (orderBook.removeOrder(orderId)) {
                return;
            }
        }
        throw new RuntimeException("Order not found");
    }

    public Map<String, OrderBook> getOrderBooks() {
        return orderBooks;
    }

    private void matchOrders(String stockSymbol) {
        OrderBook orderBook = orderBooks.get(stockSymbol);
        if (orderBook != null) {
            List<Trade> trades = orderBook.matchOrders();
            for (Trade trade : trades) {
                processTrade(trade);
            }
        }
    }

    private void processTrade(Trade trade) {
        // Implement trade processing logic, e.g., updating user balances, generating trade records, etc.
    }
}
