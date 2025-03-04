package de.consultation.c25_after43lesson;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AnimalShelter <T extends Animal> {
    private List<T> animals = new ArrayList<>();

    public void admitAnimal(T animal) {
        animals.add(animal);
        log.info("Admitted {} to the shelter.", animal);
    }

    public T releaseAnimal(String name) {
        for (T animal : animals) {
            if (animal.getName().equals(name)) {
                animals.remove(animal);
                log.info("Released {} from the shelter.", animal);
                return animal;
            }
        }
        return null;
    }

    public List<T> getAnimals() {
        return new ArrayList<>(animals);
    }
}
