package splitwise;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private String id;

    private String name;

    private String email;
    private final Map<String, Double> balances;


    public User(final String name, final String phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.balances = new ConcurrentHashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

}
