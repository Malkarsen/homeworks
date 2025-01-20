package de.lessons.abstractclass_lesson31.task1;

public class Runner extends Athlete {
    public Runner(String name, int experience) {
        super(name, experience);
    }

    @Override
    public void train() {
        System.out.println(getName() + "run 5 km");
    }
}
