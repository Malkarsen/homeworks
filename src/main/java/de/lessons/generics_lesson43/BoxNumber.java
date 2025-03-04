package de.lessons.generics_lesson43;

public class BoxNumber <T extends Number> {
    private T number;

    public BoxNumber(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double getDoubleNumber() {
        return number.doubleValue();
    }
}
