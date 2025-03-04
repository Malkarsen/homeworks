package de.lessons.generics_lesson43;

public interface Container<T> {
    void add(T item);
    T get(int index);
}
