package de.lessons.abstractclass_lesson31.task1;

public abstract class Athlete {
    private String name;
    private int experience;

    public Athlete(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public abstract void train();

    public void showInfo() {
        System.out.println("Name: " + name + ", Experience: " + experience);
    }
}
