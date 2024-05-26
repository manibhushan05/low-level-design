package stackoverflow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer {
    private String id;

    private User author;

    private Question question;

    private String body;

    private List<Comment> comments;

    private int voteCount;


    private LocalDateTime createdAt;


    public Answer(User author, Question question, String body) {
        this.body = body;
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.question = question;
        this.comments = new ArrayList<>();
        this.voteCount = 0;
        this.createdAt = LocalDateTime.now();
    }

    public void upVote() {
        this.voteCount += 1;
    }

    public String getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Question getQuestion() {
        return question;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
