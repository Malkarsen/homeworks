package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask01 {
    // Фильтрация стран по первой букве
    //У вас есть список стран:
    //
    //List<String> countries = Arrays.asList("Germany", "France", "Brazil", "Argentina",
    // "Canada", "China", "Australia", "India");
    //Используя Stream API, отфильтруйте страны, названия которых начинаются на букву "C"
    public static void main(String[] args) {
        List<String> countries = Arrays.asList(
                "Germany", "France", "Brazil", "Argentina", "Canada", "China", "Australia", "India");
        List<String> filteredCountries = countries.stream()
                .filter(country -> country.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println(filteredCountries);

    }
}
