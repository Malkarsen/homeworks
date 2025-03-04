package de.lessons.generics_lesson43;

public class BoxNumberApp {
    public static void main(String[] args) {
        BoxNumber<Integer> boxNumber = new BoxNumber<>(20);
        System.out.println(boxNumber.getNumber());

        BoxNumber<Double> boxString = new BoxNumber<>(20.13);
        System.out.println(boxString.getDoubleNumber());
    }
}
