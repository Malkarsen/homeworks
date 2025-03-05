package de.lessons.genericstasks_lesson44.task4;

import java.util.ArrayList;
import java.util.List;

public class Exhibition<T extends Artwork> {
    private List<T> artworks = new ArrayList<T>();

    public void addArtwork(T artwork) {
        if (artwork.getStyle().getName().equalsIgnoreCase("Impressionism")
                || artwork.getStyle().getName().equalsIgnoreCase("Cubism")) {
            artworks.add(artwork);
        } else {
            System.out.println("It is incorrect style");
        }
    }

    public void displayArtworks() {
        for (T artwork : artworks) {
            System.out.println(artwork);
        }
    }
}
