package de.lessons.abstractclass_lesson31.task1;

import java.util.ArrayList;
import java.util.List;

public class SportManager {
    public static void main(String[] args) {
        List<Athlete> athleteList = new ArrayList<>();
        Athlete max = new Runner("Max", 3);
        athleteList.add(max);
        athleteList.add(new Swimmer("Jane", 2));
        athleteList.add(new Runner("Bob", 1));
        athleteList.add(new Swimmer("Alice", 4));

        for (Athlete athlete : athleteList) {
            athlete.showInfo();
            athlete.train();
            System.out.println("--------------");
        }
    }
}
