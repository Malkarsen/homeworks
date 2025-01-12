package de.homeworks.homework29;

public class Post {
    private String author; // автор поста
    private String content; // содержание поста
    private int likes; // количество лайков

    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        this.likes = 0;
    }

    public void like() {
        likes++;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public void printInfo() {
        System.out.println("Author: " + author +
                ", Content: " + content +
                ", Likes: " + likes);
    }
}
