package de.lessons.generics_lesson43;

import java.util.ArrayList;
import java.util.List;

public class ListFilteredValue {
    public List<Double> getFilteredList(List<? extends Number> list, double maxValue) {
        List<Double> result = new ArrayList<>();
        for (Number number : list) {
            if (number.doubleValue() >= maxValue) {
                result.add(number.doubleValue());
            }
        }
        return result;
    }
}
