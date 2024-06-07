package stockexchange;

import java.util.Date;

public class Trade {
    private String tradeId;
    private Order buyOrder;
    private Order sellOrder;
    private int quantity;
    private double price;
    private Date timestamp;

    public Trade(String tradeId, Order buyOrder, Order sellOrder, int quantity, double price, Date timestamp) {
        this.tradeId = tradeId;
        this.buyOrder = buyOrder;
        this.sellOrder = sellOrder;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }

    public String getTradeId() {
        return tradeId;
    }

    public Order getBuyOrder() {
        return buyOrder;
    }

    public Order getSellOrder() {
        return sellOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}