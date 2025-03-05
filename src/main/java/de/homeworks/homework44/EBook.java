package de.homeworks.homework44;

public class EBook extends Book {
    private double fileSizeMb;

    public EBook(String title, String author, double fileSizeMb) {
        super(title, author);
        this.fileSizeMb = fileSizeMb;
    }

    @Override
    public String getDescription() {
        return "E-Book: " + getTitle() + " by " + getAuthor()
                + " (File size: " + fileSizeMb + " MB)";
    }
}
