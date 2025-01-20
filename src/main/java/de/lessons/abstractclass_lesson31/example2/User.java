package de.lessons.abstractclass_lesson31.example2;

public abstract class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Абстрактный класс - реализуется наследниками
    public abstract void performAction();
}
