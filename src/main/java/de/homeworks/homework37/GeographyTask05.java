package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask05 {
    // Фильтрация стран с названием из 6 букв
    //Дан список стран:
    //
    //List<String> countries = Arrays.asList("Mexico", "Sweden",
    // "Brazil", "Russia", "Canada", "France", "Norway");
    //Используя Stream API, отфильтруйте страны, название которых состоит из 6 букв.
    public static void main(String[] args) {
        List<String> countries = Arrays.asList(
                "Mexico", "Sweden", "Brazil", "Russia", "Canada", "France", "Norway");
        List<String> filteredCountriesWith6Chars = countries.stream()
                .filter(country -> country.length() == 6)
                .collect(Collectors.toList());
        System.out.println(filteredCountriesWith6Chars);
    }
}
