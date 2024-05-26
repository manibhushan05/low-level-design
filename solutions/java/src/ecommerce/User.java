package ecommerce;

import java.util.UUID;

public class User {
    private String id;

    private String name;

    private String phone;


    public User(String name, String phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
