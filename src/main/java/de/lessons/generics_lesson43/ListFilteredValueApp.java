package de.lessons.generics_lesson43;

import java.util.Arrays;
import java.util.List;

public class ListFilteredValueApp {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ListFilteredValue listFilteredValue = new ListFilteredValue();
        List<Double> result = listFilteredValue.getFilteredList(integerList, 4);
        System.out.println(result);
    }
}
