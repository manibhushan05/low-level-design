package stackoverflow;

public class User {
    private String id;

    private String username;

    private String name;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
