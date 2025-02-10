package de.homeworks.homework37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeographyTask08 {
    // Определение рек, содержащих более 7 букв
    //Используя Stream API, отфильтруйте реки, название которых содержит более 7 букв.
    public static void main(String[] args) {
        List<String> rivers = Arrays.asList(
                "Colorado", "Nile", "Yangtze", "Mississippi", "Danube", "Main", "Ganges");
        List<String> filteredRivers = rivers.stream()
                .filter(river -> river.length() > 7)
                .collect(Collectors.toList());
        System.out.println(filteredRivers);
    }
}
