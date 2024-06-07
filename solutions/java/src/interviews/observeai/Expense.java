package interviews.observeai;

import java.util.List;

public class Expense {
    private String payer;
    private double amount;
    private List<String> users;
    private String expenseType;
    private List<Double> values;

    public Expense(String payer, double amount, List<String> users, String expenseType, List<Double> values) {
        this.payer = payer;
        this.amount = amount;
        this.users = users;
        this.expenseType = expenseType;
        this.values = values;
    }

    public String getPayer() {
        return payer;
    }

    public double getAmount() {
        return amount;
    }

    public List<String> getUsers() {
        return users;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public List<Double> getValues() {
        return values;
    }
}
