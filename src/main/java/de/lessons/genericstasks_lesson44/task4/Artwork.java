package de.lessons.genericstasks_lesson44.task4;

public class Artwork {
    private String title;
    private String artist;
    private ArtStyle style;

    public Artwork(String title, String artist, ArtStyle style) {
        this.title = title;
        this.artist = artist;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public ArtStyle getStyle() {
        return style;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setStyle(ArtStyle style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", style=" + style +
                '}';
    }
}
