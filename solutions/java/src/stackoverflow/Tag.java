package stackoverflow;

import java.util.UUID;

public class Tag {
    private String id;

    private String name;

    public Tag(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
