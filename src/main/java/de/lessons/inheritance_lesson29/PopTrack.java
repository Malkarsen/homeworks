package de.lessons.inheritance_lesson29;

public class PopTrack extends MusicTrack {
    private int popularity;

    public PopTrack(String title, String artist, int popularity) {
        super(title, artist);
        this.popularity = popularity;
    }

    @Override
    public void play() {
        System.out.println("Playing pop track: " + popularity );
    }
}
