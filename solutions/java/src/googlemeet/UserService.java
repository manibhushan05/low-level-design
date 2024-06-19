package googlemeet;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private static UserService instance;
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User register(final String userId, final String email, final String username) {
        if (!users.containsKey(userId)) {
            User user = new User(userId, username, email, UUID.randomUUID().toString());
            users.put(userId, user);
            return user;
        }
        return users.get(userId);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}

