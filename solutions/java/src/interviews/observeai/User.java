package interviews.observeai;

public class User {
    private final String userId;
    private final String name;
    private final String email;
    private final String mobile;

    public User(String userId, String name, String email, String mobile) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUserId() {
        return userId;
    }
}
