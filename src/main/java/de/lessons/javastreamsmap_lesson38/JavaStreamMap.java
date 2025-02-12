package de.lessons.javastreamsmap_lesson38;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

public class JavaStreamMap {
    private static List<String> cars = List.of("Volvo", "BMW", "Ford", "Mazda", "Bentley", "Mercedes");
    private static List<String> phrases = List.of("Hello java", "Goodbye and love you", "Thank you much", "See you later");

    public static void main(String[] args) {
        List<Integer> carsNameLength = cars.stream()
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("CarsNameLengths: " + carsNameLength);

        List<String> words = phrases.stream()
                .flatMap(phrases-> Arrays.stream(phrases.split(" ")))
                .collect(Collectors.toList());
        System.out.println(words);

        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> listResult = lists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(listResult);

        long listsResultCount = lists.stream()
                .flatMap (Collection::stream)
                .count();
        System.out.println("listResultCount: " + listsResultCount);

        boolean hasEven = lists.stream()
                .anyMatch(list -> list.stream().anyMatch(i -> i % 2 == 0));

        List<String> carsResult = cars.stream()
                .filter(cars -> {
                    System.out.println("filtering: " + cars);
                    return cars.length() > 5;
                })
                .map(cars1 -> {
                    System.out.println("mapping: " + cars1);
                    return cars1.toUpperCase();
                })
                .distinct()
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(carsResult);
    }
}
