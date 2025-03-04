package de.consultation.c25_after43lesson;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

public class AnimalApp {
    public static void main(String[] args) {
        AnimalShelter<DogAnimal> dogAnimalShelter = new AnimalShelter<>();
        dogAnimalShelter.admitAnimal(new DogAnimal("Rex", 5));
        dogAnimalShelter.admitAnimal(new DogAnimal("Buddy", 7));
        dogAnimalShelter.admitAnimal(new DogAnimal("Max", 3));
        dogAnimalShelter.admitAnimal(new DogAnimal("Fido", 10));
        dogAnimalShelter.admitAnimal(new DogAnimal("Snoopy", 6));

        AnimalShelter<CatAnimal> catAnimalShelter = new AnimalShelter<>();
        catAnimalShelter.admitAnimal(new CatAnimal("Tom", 2));
        catAnimalShelter.admitAnimal(new CatAnimal("Kitty", 1));
        catAnimalShelter.admitAnimal(new CatAnimal("Luna", 4));
        catAnimalShelter.admitAnimal(new CatAnimal("Whiskers", 3));
        catAnimalShelter.admitAnimal(new CatAnimal("Momo", 5));

        DogAnimal resultMax = dogAnimalShelter.releaseAnimal("Max");
        System.out.println("The adopted dog is " + resultMax.getName());

        System.out.println(dogAnimalShelter.getAnimals());
        List<CatAnimal> catAnimal = catAnimalShelter.getAnimals();
        for (CatAnimal animal : catAnimal) {
            animal.makeSound();
        }
    }
}
