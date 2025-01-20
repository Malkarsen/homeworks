package de.lessons.abstractclass_lesson31.task2;

public abstract class Competition {
    private String competitionName;

    public Competition(String competitionName) {
        this.competitionName = competitionName;
    }

    public abstract void startCompetition();

    public void showCompetitionInfo() {
        System.out.println("Competition Name: " + competitionName);
    }
}
