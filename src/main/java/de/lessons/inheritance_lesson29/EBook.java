package de.lessons.inheritance_lesson29;

public class EBook extends Book {
    private double fileSize;

    public EBook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    @Override
    public void read() {
        System.out.println("Reading " + title + " by " + author + " in electronic format");
    }

    public void download() {
        System.out.println("Downloading " + title + " size: " + fileSize + "MB");
    }
}
