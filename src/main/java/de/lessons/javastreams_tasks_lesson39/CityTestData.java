package de.lessons.javastreams_tasks_lesson39;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CityTestData {
    public List<City> getCities() {
        return Arrays.asList(
                // США
                new City("New York", "USA", 8_399_000, true),
                new City("Los Angeles", "USA", 3_990_000, true),
                new City("Chicago", "USA", 2_716_000, false),
                new City("Houston", "USA", 2_325_502, false),
                new City("Miami", "USA", 470_914, true),

                // Япония
                new City("Tokyo", "Japan", 13_960_000, true),
                new City("Osaka", "Japan", 2_715_000, true),
                new City("Kyoto", "Japan", 1_475_000, false),

                // Германия
                new City("Berlin", "Germany", 3_644_826, false),
                new City("Hamburg", "Germany", 1_841_000, true),
                new City("Munich", "Germany", 1_472_000, false),

                // Франция
                new City("Paris", "France", 2_140_526, false),
                new City("Marseille", "France", 861_635, true),
                new City("Lyon", "France", 515_695, false),

                // Австралия
                new City("Sydney", "Australia", 5_312_163, true),
                new City("Melbourne", "Australia", 4_967_733, false),
                new City("Brisbane", "Australia", 2_280_000, true),

                // Бразилия
                new City("Rio de Janeiro", "Brazil", 6_718_903, true),
                new City("Sao Paulo", "Brazil", 12_252_023, false),

                // Великобритания
                new City("London", "UK", 8_982_000, false),
                new City("Manchester", "UK", 547_627, false),

                // Италия
                new City("Rome", "Italy", 2_873_494, false),
                new City("Venice", "Italy", 261_905, true),
                new City("Milan", "Italy", 1_352_000, false)
        );
    }
}
