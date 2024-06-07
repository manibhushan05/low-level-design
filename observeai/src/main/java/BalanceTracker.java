import java.util.HashMap;
import java.util.Map;

public class BalanceTracker {
    private Map<String, Map<String, Double>> balances;

    public BalanceTracker() {
        balances = new HashMap<>();
    }

    public void addBalance(String fromUser, String toUser, double amount) {
        balances.putIfAbsent(fromUser, new HashMap<>());
        balances.putIfAbsent(toUser, new HashMap<>());

        balances.get(fromUser).put(toUser, balances.get(fromUser).getOrDefault(toUser, 0.0) + amount);
        balances.get(toUser).put(fromUser, balances.get(toUser).getOrDefault(fromUser, 0.0) - amount);
    }

    public void showBalances() {
        boolean hasBalances = false;
        for (String fromUser : balances.keySet()) {
            for (String toUser : balances.get(fromUser).keySet()) {
                double amount = balances.get(fromUser).get(toUser);
                if (amount > 0) {
                    hasBalances = true;
                    System.out.println(fromUser + " owes " + toUser + ": " + String.format("%.2f", amount));
                }
            }
        }
        if (!hasBalances) {
            System.out.println("No balances");
        }
    }

    public void showUserBalances(String userId) {
        boolean hasBalances = false;
        if (balances.containsKey(userId)) {
            for (String toUser : balances.get(userId).keySet()) {
                double amount = balances.get(userId).get(toUser);
                if (amount > 0) {
                    hasBalances = true;
                    System.out.println(userId + " owes " + toUser + ": " + String.format("%.2f", amount));
                } else if (amount < 0) {
                    hasBalances = true;
                    System.out.println(toUser + " owes " + userId + ": " + String.format("%.2f", -amount));
                }
            }
        }
        if (!hasBalances) {
            System.out.println("No balances");
        }
    }
}
