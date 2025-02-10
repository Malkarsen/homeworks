package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask07 {
    // Фильтрация городов по последней букве
    //Используя Stream API, отфильтруйте города, у которых название заканчивается на "o".
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Berlin", "Buenos Aires", "Paris", "Chicago", "Toronto", "London", "Beijing");
        List<String> filteredCities = cities.stream()
                .filter(city -> city.toLowerCase().endsWith("o"))
                .collect(Collectors.toList());
        System.out.println(filteredCities);
    }
}
