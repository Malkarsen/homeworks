package de.lessons.genericstasks_lesson44.task3;

import java.util.ArrayList;
import java.util.List;

public class ModernArtGallery<T extends ArtPiece> {
    private List<T> artPieces = new ArrayList<T>();

    public void addArtPiece(T artPiece) {
        if (artPiece.getYear() >= 1900) {
            artPieces.add(artPiece);
        } else {
            System.out.println("It is too old");
        }
    }

    public void displayArtPieces() {
        for (T artPiece : artPieces) {
            System.out.println(artPiece);
        }
    }
}
