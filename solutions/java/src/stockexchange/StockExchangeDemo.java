package stockexchange;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class StockExchangeDemo {
    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("AWS","REL");
        StockExchange stockExchange = new StockExchange(symbols);
        User mani = new User("1", "Mani", 100);
        Order order = new Order(UUID.randomUUID().toString(),mani,symbols.get(0),5, 100.0, OrderType.BUY );
        stockExchange.placeOrder(order);
        System.out.println( stockExchange.getOrderBooks().toString());
        stockExchange.cancelOrder(order.getOrderId());
    }
}
