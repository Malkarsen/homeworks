package de.lessons.genericstasks_lesson44.task5;

import java.util.ArrayList;
import java.util.List;

public class ArtCollection<T extends Artist> {
    private List<T> artists = new ArrayList<>();

    public void addArtist(T artist) {
        artists.add(artist);
    }

    public Artist getArtistByName(String artistName) {
        for (T artist : artists) {
            if (artist.getName().equalsIgnoreCase(artistName)) {
                return artist;
            }
        }
        return null;
    }
}