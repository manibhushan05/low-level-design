package splitwise;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String id;

    private final double amount;

    private final Date transactionDate;

    private final User sender;
    private final User receiver;

    public Transaction(final String id,final double amount,final User sender, final User receiver) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = new Date();
        this.sender = sender;
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public User getReceiver() {
        return receiver;
    }

    public User getSender() {
        return sender;
    }
}
