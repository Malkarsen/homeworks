package de.homeworks.homework30.task1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LikesAndPostManager {
    public static void main(String[] args) {
        Post post = new Post("Hey, everyone!");
        post.addComment("Hello, world!");
        post.addComment("Hello");
        post.like();
        post.like();

        System.out.println("Post: " + post.getContent() + " has likes: " + post.getLikesCount());
        log.info("Post: {} has likes: {}", post.getContent(), post.getLikesCount());
        if (!post.getComments().isEmpty()) {
            System.out.println("Post: " + post.getContent() + " has comments:");
            log.info("Post: {} has comments:", post.getContent());
            for (String comment : post.getComments()) {
                System.out.println(comment);
                log.info("Comment: {}", comment);
            }
        }
        post.printInfo();
    }
}
