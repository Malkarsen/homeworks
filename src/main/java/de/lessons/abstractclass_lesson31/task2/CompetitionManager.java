package de.lessons.abstractclass_lesson31.task2;

import java.util.ArrayList;
import java.util.List;

public class CompetitionManager {
    public static void main(String[] args) {
        List<Competition> competitionList = new ArrayList<>();
        competitionList.add(new Marathon("Marathon"));
        competitionList.add(new SwimmingChampionship("Swimming Championship"));

        for (Competition competition : competitionList) {
            competition.showCompetitionInfo();
            competition.startCompetition();
            System.out.println("----------------");
        }
    }
}
