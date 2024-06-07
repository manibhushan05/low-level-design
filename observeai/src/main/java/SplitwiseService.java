import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SplitwiseService {
    private Map<String, User> users;
    private BalanceTracker balanceTracker;

    public SplitwiseService() {
        users = new ConcurrentHashMap<>();
        balanceTracker = new BalanceTracker();
    }

    public void addUser(String userId, String name, String email, String mobile) {
        users.put(userId, new User(userId, name, email, mobile));
    }

    public void addExpense(String payer, double amount, List<String> users, SplitType expenseType, List<Double> values) {
        if (expenseType.equals(SplitType.EQUAL)) {
            double share = round(amount / users.size());
            for (String user : users) {
                if (!user.equals(payer)) {
                    balanceTracker.addBalance(user, payer, share);
                }
            }
        } else if (expenseType.equals(SplitType.EXACT)) {
            double total = values.stream().mapToDouble(Double::doubleValue).sum();
            if (total != amount) {
                throw new IllegalArgumentException("Sum of exact values does not match the total amount.");
            }
            for (int i = 0; i < users.size(); i++) {
                String user = users.get(i);
                double share = values.get(i);
                if (!user.equals(payer)) {
                    balanceTracker.addBalance(user, payer, share);
                }
            }
        } else if (expenseType.equals(SplitType.PERCENT)) {
            double total = values.stream().mapToDouble(Double::doubleValue).sum();
            if (total != 100) {
                throw new IllegalArgumentException("Sum of percent values does not equal 100.");
            }
            for (int i = 0; i < users.size(); i++) {
                String user = users.get(i);
                double share = round((values.get(i) / 100) * amount);
                if (!user.equals(payer)) {
                    balanceTracker.addBalance(user, payer, share);
                }
            }
        }
    }

    public void showBalances() {
        balanceTracker.showBalances();
    }

    public void showUserBalances(String userId) {
        balanceTracker.showUserBalances(userId);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
