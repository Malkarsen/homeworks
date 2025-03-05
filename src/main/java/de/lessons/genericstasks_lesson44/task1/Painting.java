package de.lessons.genericstasks_lesson44.task1;

public class Painting {
    private String title;
    private String artist;

    public Painting(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Painting [title=" + title + ", artist=" + artist + "]";
    }
}
