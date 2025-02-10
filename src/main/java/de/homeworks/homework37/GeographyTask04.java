package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask04 {
    // Фильтрация континентов по количеству символов
    //Дан список континентов:
    //
    //List<String> continents = Arrays.asList("Europe", "Asia", "Africa",
    // "Australia", "Antarctica", "South America", "North America");
    //Используя Stream API, отфильтруйте континенты, у которых название короче 7 символов.
    public static void main(String[] args) {
        List<String> continents = Arrays.asList(
                "Europe", "Asia", "Africa", "Australia", "Antarctica", "South America", "North America");
        List<String> filteredContinents = continents.stream()
                .filter(country -> country.length() < 7)
                .collect(Collectors.toList());
        System.out.println(filteredContinents);
    }
}
