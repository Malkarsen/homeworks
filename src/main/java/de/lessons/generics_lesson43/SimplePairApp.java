package de.lessons.generics_lesson43;

public class SimplePairApp {
    public static void main(String[] args) {
        SimplePair<Integer, String> pair = new SimplePair<>(1, "Hello");
        System.out.println("Key element: " + pair.getKey());
        System.out.println("Value element: " + pair.getValue());

        System.out.println("--------------------------------");
        SimplePair<String, Integer> pair2 = new SimplePair<>("Hello", 1);
        System.out.println("Key element: " + pair2.getKey());
        System.out.println("Value element: " + pair2.getValue());
    }
}
