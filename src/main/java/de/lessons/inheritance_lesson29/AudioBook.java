package de.lessons.inheritance_lesson29;

public class AudioBook extends Book {
    private double durationMinutes;

    public AudioBook(String title, String author, double durationMinutes) {
        super(title, author);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void read() {
        System.out.println("Reading " + title + " by " + author + " in audio format");
    }

    public void listen() {
        System.out.println("Listening to " + title + " duration: " + durationMinutes + " minutes");
    }
}
