package de.lessons.javastreams_lesson37;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {
    public static void main(String[] args) {
        List<String> cars = List.of("Volvo", "BMW", "Ford", "Mazda", "Bentley", "Mercedes");

        List<String> result = cars.stream()
                .filter(carName -> carName.startsWith("B"))
                .collect(Collectors.toList());
        System.out.println(result);

        String[] carsArray = {"Volvo", "BMW", "Ford", "Mazda", "Bentley", "Mercedes"};
        List<String> resultArray = Arrays.stream(carsArray)
                .filter(carName -> carName.startsWith("B"))
                .filter(carName -> carName.length() == 3)
                .collect(Collectors.toList());
        System.out.println(resultArray);

        List<String> resultArrayLength = Arrays.stream(carsArray)
                .filter(carName -> carName.length() == 5)
                .collect(Collectors.toList());
        System.out.println(resultArrayLength);

        List<Integer> integerList = List.of(1, 5, 8, 4, 12, 26, 23, 90, 67);
        List<Integer> evenNumber = integerList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumber);
    }
}
