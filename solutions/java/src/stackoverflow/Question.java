package stackoverflow;

import java.time.LocalDateTime;
import java.util.*;

public class Question {
    private String id;

    private User author;

    private String body;

    private List<Answer> answers;

    private List<Comment> comments;

    private Set<Tag> tags;

    private LocalDateTime createdAt;

    public Question(User author, String body) {
        this.author = author;
        this.body = body;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new HashSet<>();
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public void addTags(Tag tag) {
        this.tags.add(tag);
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getBody() {
        return body;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}
