package splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String id;
    private final String description;
    private final double amount;

    private final User paidBy;

    private final List<Split> splits;

    public Expense(String description, double amount, User paidBy) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = new ArrayList<>();
    }

    public void addSplit(Split split) {
        splits.add(split);
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }
}
