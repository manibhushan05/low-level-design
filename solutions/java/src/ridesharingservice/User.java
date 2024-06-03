package ridesharingservice;

public  class User {
    private final String id;
    private final String name;
    private final String phone;

    protected User(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
