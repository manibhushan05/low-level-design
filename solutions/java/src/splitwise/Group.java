package splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private String id;
    private String name;
    private List<User> users;
    private List<Expense> expenses;

    public Group(final String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getId() {
        return id;
    }
}
