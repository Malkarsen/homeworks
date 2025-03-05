package de.lessons.genericstasks_lesson44.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArtGallery<T> {
    private List<T> paintings = new ArrayList<T>();

    public void addPainting(T painting) {
        paintings.add(painting);
        log.info("Added painting: {}", painting);
    }

    public void displayAllPaintings() {
        for (T painting : paintings) {
            System.out.println(painting);
        }
    }
}
