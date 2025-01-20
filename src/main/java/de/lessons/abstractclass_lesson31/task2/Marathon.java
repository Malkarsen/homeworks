package de.lessons.abstractclass_lesson31.task2;

public class Marathon extends Competition {
    public Marathon(String competitionName) {
        super(competitionName);
    }

    @Override
    public void startCompetition() {
        System.out.println("Марафон начался! Участники бегут 42 км.");
    }
}
