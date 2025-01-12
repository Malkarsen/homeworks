package de.lessons.inheritance_lesson29;

public class Book {
    protected String title;
    protected String author;

    public Book (String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void printInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }

    public void read() {
        System.out.println("Reading " + title + " by " + author + " in papier format");
    }
}
