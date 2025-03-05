package de.lessons.genericstasks_lesson44.task2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Museum<T extends Artwork> {
    private List<T> artworks = new ArrayList<T>();

    public void addItem(T item) {
        artworks.add(item);
        log.info("Added item: {}", item);
    }

    public void displayAllArtworks() {
        for (T artwork : artworks) {
            System.out.println(artwork);
        }
    }
}
