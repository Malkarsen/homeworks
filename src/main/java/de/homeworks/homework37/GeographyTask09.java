package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask09 {
    // Фильтрация континентов по первой букве
    //Используя Stream API, отфильтруйте континенты, названия которых начинаются на "A".
    public static void main(String[] args) {
        List<String> continents = Arrays.asList(
                "Europe", "Asia", "Africa", "Australia", "Antarctica", "South America", "North America");
        List<String> filteredContinents = continents.stream()
                .filter(country -> country.toUpperCase().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(filteredContinents);
    }
}
