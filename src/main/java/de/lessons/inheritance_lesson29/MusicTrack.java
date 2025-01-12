package de.lessons.inheritance_lesson29;

public class MusicTrack {
    private String title;
    private String artist;

    public MusicTrack(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void printInfo() {
        System.out.println("Title: " + title + ", Artist: " + artist);
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
