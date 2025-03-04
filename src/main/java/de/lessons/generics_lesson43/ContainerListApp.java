package de.lessons.generics_lesson43;

import java.util.ArrayList;
import java.util.List;

public class ContainerListApp<T> implements Container<T> {
    private List<T> elements = new ArrayList<>();
    @Override
    public void add(T item) {
        elements.add(item);
    }

    @Override
    public T get(int index) {
        return elements.get(index);
    }

    public <T> void printElements(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public List<T> getElements() {
        return elements;
    }
}
