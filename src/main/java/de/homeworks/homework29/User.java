package de.homeworks.homework29;

public class User {
    private String id; // уникальный идентификатор пользователя
    private String name; // имя пользователя
    private String email; // электронная почта

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void printInfo() {
        System.out.println("Type: User" +
                ", ID: " + id +
                ", Name: " + name +
                ", Email: " + email);
    }
}
