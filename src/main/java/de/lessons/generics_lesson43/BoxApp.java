package de.lessons.generics_lesson43;

import com.github.javafaker.Faker;

public class BoxApp {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("Hello world!");
        String resultGetterBox = stringBox.getValue();
        System.out.println(resultGetterBox);

        Box<Double> doubleBox = new Box<>(123.45);
        double resultGetterDoubleBox = doubleBox.getValue();
        System.out.println(resultGetterDoubleBox);

        Faker faker = new Faker();
        Person person = new Person(faker.name().fullName(), 34, "1234");
        Box<Person> personBox = new Box<>(person);
        Person resultGetterPersonBox = personBox.getValue();
        System.out.println(resultGetterPersonBox);
    }
}
