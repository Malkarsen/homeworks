package de.lessons.inheritance_lesson29;

public class RockTrack extends MusicTrack{
    private int rockLevel;

    public RockTrack(String title, String artist, int rockLevel) {
        super(title, artist);
        this.rockLevel = rockLevel;
    }

    @Override
    public void play() {
        System.out.println("Rock level " + rockLevel);
    }
}
