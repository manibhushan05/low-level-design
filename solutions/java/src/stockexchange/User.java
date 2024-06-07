package stockexchange;

public class User {
    private String userId;
    private String name;
    private double balance;

    public User(String userId, String name, double balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
