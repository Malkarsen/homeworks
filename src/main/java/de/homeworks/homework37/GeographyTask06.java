package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask06 {
    // Поиск стран с названием, содержащим букву "a"
    //Используя Stream API, отфильтруйте страны, названия которых содержат букву "a".
    public static void main(String[] args) {
        List<String> countries = Arrays.asList(
                "Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");
        List<String> filteredCountriesWithA = countries.stream()
                .filter(country -> country.toLowerCase().contains("a"))
                .collect(Collectors.toList());
        System.out.println(filteredCountriesWithA);
    }
}
