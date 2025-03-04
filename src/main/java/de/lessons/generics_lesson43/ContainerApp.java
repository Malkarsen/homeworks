package de.lessons.generics_lesson43;

import com.github.javafaker.Faker;

import java.util.List;

public class ContainerApp {
    public static void main(String[] args) {
        ContainerListApp<String> app = new ContainerListApp<>();
        app.add("Hello");
        app.add("World");
        app.add("!");
        System.out.println(app.get(0));

        ContainerListApp<Person> personApp = new ContainerListApp<>();
        Faker faker = new Faker();
        Person person = new Person(faker.name().fullName(), 34, "1234");
        personApp.add(person);
        System.out.println(personApp.get(0));

        List<Person> result = personApp.getElements();
        personApp.printElements(result);
    }
}
