package de.consultation.c25_after43lesson;

public class CatAnimal extends Animal {
    public CatAnimal(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! My name is " + getName() + " and my age is " + getAge());
    }
}
