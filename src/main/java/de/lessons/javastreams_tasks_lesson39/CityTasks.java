package de.lessons.javastreams_tasks_lesson39;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CityTasks {
    private static CityTestData data = new CityTestData();

    public static void main(String[] args) {
        System.out.println("List coastal cities: \n" + getCoastalCities());
        System.out.println("List uppercase city names: \n" + getUppercaseCityNames());
        System.out.println("List sorted by population: \n" + getSortedCityPopulation());
        System.out.println("List sorted by country: \n" + getSortedCityNames());
        System.out.println("Count of cities with population more than 5M: " + countCitiesWithPopulationAbove5Million());
        System.out.println("City with the highest population: " + getCityWithMaxPopulation());
        System.out.println("City with the lowest population: " + getCityWithMinPopulation());
    }

    // Упражнение 1: Фильтрация городов по некоторому условию
    //Задание:
    //Вывести список всех прибрежных (isCoastal = true) городов.
    public static List<String> getCoastalCities() {
        return data.getCities().stream()
                .filter(City::isCoastal)
                .map(City::getName)
                .collect(Collectors.toList());
    }

    // Упражнение 2: Преобразование (map) списка городов
    //Задание:
    //Получить список названий всех городов в верхнем регистре.
    public static List<String> getUppercaseCityNames() {
        return data.getCities().stream()
                .map(city -> new City(city.getName().toUpperCase(), city.getCountry(), city.getPopulation(), city.isCoastal()))
                .map(City::getName)
                .collect(Collectors.toList());
    }

    // Упражнение 3: Сортировка (sorted) городов
    //Задание (вариант А):
    //Отсортировать города по возрастанию численности населения.
    //Задание (вариант Б):
    //Отсортировать города по названию (лексикографически).
    public static List<City> getSortedCityPopulation() {
        return data.getCities().stream()
                .sorted(Comparator.comparingInt(City::getPopulation))
                .collect(Collectors.toList());
    }
    public static List<City> getSortedCityNames() {
        return data.getCities().stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
    }

    // Упражнение 4: Подсчёт (count)
    //Задание:
    //Подсчитать количество городов, население которых превышает 5 миллионов.
    public static long countCitiesWithPopulationAbove5Million() {
        return data.getCities().stream()
                .filter(city -> city.getPopulation() > 5_000_000)
                .count();
    }

    // Упражнение 5: Поиск минимума и максимума (min, max)
    //Задание (вариант А):
    //Найти город с минимальным населением.
    //Задание (вариант Б):
    //Найти город с максимальным населением.
    public static Optional<City> getCityWithMinPopulation() {
        return data.getCities().stream()
                .max(Comparator.comparingInt(City::getPopulation));
    }

    public static Optional<City> getCityWithMaxPopulation() {
        return data.getCities().stream()
                .min(Comparator.comparingInt(City::getPopulation));
    }
}
