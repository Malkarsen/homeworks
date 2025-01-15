package de.homeworks.homework30.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Post implements Likable, Commentable {
    private String content;
    private int likesCount;
    private List<String> comments;

    public Post(String content) {
        this.content = content;
        this.likesCount = 0;
        this.comments = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    @Override
    public void like() {
        likesCount++;
        log.info("Post got like. Now post has {} likes", likesCount);
    }

    @Override
    public int getLikesCount() {
        return likesCount;
    }

    @Override
    public void addComment(String comment) {
        if (comment == null || comment.isEmpty()) {
            log.error("Comment is null or empty");
            System.out.println("Comment is null or empty");
        } else {
            comments.add(comment);
            log.info("New comment added: {}", comment);
            System.out.println("New comment added: " + comment);
        }
    }

    @Override
    public List<String> getComments() {
        return new ArrayList<>(comments);
    }

    public void printInfo() {
        System.out.println("Content: " + content +
                ", Likes: " + likesCount +
                ", Comments: " + comments);
    }
}
