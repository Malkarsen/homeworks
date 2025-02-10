package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask03 {
    // Фильтрация рек с четным количеством букв в названии
    //Дан список рек:
    //
    //List<String> rivers = Arrays.asList("Amazon", "Nile", "Yangtze",
    // "Mississippi", "Danube", "Main", "Ganges");
    //Используя Stream API, отфильтруйте только те реки, у которых чётное количество букв в названии.
    public static void main(String[] args) {
        List<String> rivers = Arrays.asList(
                "Amazon", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges");
        List<String> filteredRivers = rivers.stream()
                .filter(river -> river.length() % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filteredRivers);
    }
}
