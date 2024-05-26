package ecommerce;

public class User {
    private String id;

    private String name;

    private String phone;

    public User(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}
