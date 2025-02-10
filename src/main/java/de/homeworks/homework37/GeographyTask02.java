package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask02 {
    // Фильтрация городов по длине названия
    //У вас есть список городов:
    //
    //List<String> cities = Arrays.asList("Berlin", "Buenos Aires", "Paris",
    // "Los Angeles", "New York", "London", "Beijing");
    //Используя Stream API, отфильтруйте города, название которых длиннее 6 символов.
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Berlin", "Buenos Aires", "Paris", "Los Angeles", "New York", "London", "Beijing");
        List<String> filteredCities = cities.stream()
                .filter(city -> city.length() > 6)
                .collect(Collectors.toList());
        System.out.println(filteredCities);
    }
}
