package stackoverflow;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private String id;

    private String body;

    private User author;

    private LocalDateTime createdAt;


    public Comment(String body, User author) {
        this.body = body;
        this.author = author;
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }
}
