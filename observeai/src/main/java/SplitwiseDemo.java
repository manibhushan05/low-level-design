import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitwiseDemo {
    public static void main(String[] args) {
        SplitwiseService splitwiseService = new SplitwiseService();

        // Adding users
        splitwiseService.addUser("u1", "User1", "user1@example.com", "1234567890");
        splitwiseService.addUser("u2", "User2", "user2@example.com", "1234567891");
        splitwiseService.addUser("u3", "User3", "user3@example.com", "1234567892");
        splitwiseService.addUser("u4", "User4", "user4@example.com", "1234567893");

        // Sample inputs and outputs
        String[] commands = {
                "SHOW",
                "SHOW u1",
                "EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL",
                "SHOW u4",
                "SHOW u1",
                "EXPENSE u1 1250 2 u2 u3 EXACT 370 880",
                "SHOW",
                "EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20",
                "SHOW u1",
                "SHOW"
        };

        for (String command : commands) {
            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("SHOW")) {
                if (parts.length == 1) {
                    splitwiseService.showBalances();
                } else {
                    String userId = parts[1];
                    splitwiseService.showUserBalances(userId);
                }
            } else if (action.equals("EXPENSE")) {
                String payer = parts[1];
                double amount = Double.parseDouble(parts[2]);
                int numUsers = Integer.parseInt(parts[3]);
                String[] userArray = Arrays.copyOfRange(parts, 4, 4 + numUsers);
                List<String> users = Arrays.asList(userArray);
                SplitType expenseType = SplitType.fromString(parts[4 + numUsers]);
                List<Double> values = new ArrayList<>();
                if (!expenseType.equals(SplitType.EQUAL)) {
                    for (int i = 5 + numUsers; i < parts.length; i++) {
                        values.add(Double.parseDouble(parts[i]));
                    }
                }
                splitwiseService.addExpense(payer, amount, users, expenseType, values);
            }
        }
    }
}
