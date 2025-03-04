package de.consultation.c25_after43lesson;

public class DogAnimal extends Animal {
    public DogAnimal(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! My name is " + getName() + " and my age is " + getAge());
    }
}
