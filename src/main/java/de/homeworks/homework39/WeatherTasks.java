package de.homeworks.homework39;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherTasks {
    public static WeatherTestData data = new WeatherTestData();

    public static void main(String[] args) {
        // Task 1
        List<Weather> listBelowZero = getCitiesWhereTemperatureBelowZero();
        if (!listBelowZero.isEmpty()) {
            System.out.println("City where the temperature is below zero: ");
            for (Weather weather : listBelowZero) {
                System.out.println(weather.getCity());
            }
        } else {
            System.out.println("No cities where the temperature is below zero.");
        }

        // Task 2.1
        int threshold = 25;
        boolean hasCityAboveTwentyFive = isAnyCityAboveThreshold(threshold);
        System.out.println("City where the temperature is above " + threshold + ": " + hasCityAboveTwentyFive);

        // Task 2.2
        Optional<Weather> cityWithHighestTemperature = findMaxTemperatureCity();
        if (cityWithHighestTemperature.isPresent()) {
            System.out.println("City with the highest temperature: " + cityWithHighestTemperature.get().getCity());
        } else {
            System.out.println("No cities found with the highest temperature.");
        }
        // Other tasks
        // 1
        double averageTemperature = getAverageTemperature();
        System.out.println("Average temperature: " + averageTemperature);

        // 2
        Map<Boolean, List<String>> isRainy = groupByIsRainy();
        System.out.println("Group by rainy: " + isRainy);

        // 3
        List<Weather> sortedWeather = sortByCityName();
        if (!sortedWeather.isEmpty()) {
            System.out.println("Sorted by city name: ");
            for (Weather weather : sortedWeather) {
                System.out.println(weather.getCity());
            }
        } else {
            System.out.println("No cities in list.");
        }
    }

    // Задание 1: Фильтрация данных по температуре
    // 1. Найти все записи (Weather), у которых температура опускается ниже нуля.
    // 2. Вывести результат в удобном для вас формате (например, список или строку).
    // Подсказка
    // • Используйте фильтрацию (filter) по условию temperature < 0
    public static List<Weather> getCitiesWhereTemperatureBelowZero() {
        return data.getWeatherList().stream()
                .filter(weather -> weather.getTemperature() < 0)
                .collect(Collectors.toList());
    }

    // Задание 2: Проверка условий и нахождение максимума
    // 1. Определить, есть ли хотя бы один город с температурой выше определённого порога (например, 25 градусов).
    // 2. Найти город (объект Weather) с максимальной температурой.
    // Подсказка
    // • Для проверки какого-либо условия можно использовать anyMatch.
    // • Для поиска максимума используйте max с Comparator по температуре
    public static boolean isAnyCityAboveThreshold(int threshold) {
        return data.getWeatherList().stream()
                .anyMatch(weather -> weather.getTemperature() > threshold);
    }

    public static Optional<Weather> findMaxTemperatureCity() {
        return data.getWeatherList().stream()
                .max(Comparator.comparingDouble(Weather::getTemperature));
    }

    // Подсчёт средней температуры с помощью mapToDouble и average().
    public static double getAverageTemperature() {
        return data.getWeatherList().stream()
               .mapToDouble(Weather::getTemperature)
               .average()
               .orElse(0);
    }
    // Группировка по признаку isRainy (true/false) с помощью Collectors.groupingBy(...)
    public static Map<Boolean, List<String>> groupByIsRainy() {
        return data.getWeatherList().stream()
                .collect(Collectors.groupingBy(
                        Weather::isRainy, Collectors.mapping(Weather::getCity, Collectors.toList())));
    }

    // Сортировка данных по названию города с помощью Comparator.comparing(Weather::getCity)
    public static List<Weather> sortByCityName() {
        return data.getWeatherList().stream()
               .sorted(Comparator.comparing(Weather::getCity))
               .collect(Collectors.toList());
    }
}
