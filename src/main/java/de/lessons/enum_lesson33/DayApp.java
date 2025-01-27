package de.lessons.enum_lesson33;

public class DayApp {
    public static void main(String[] args) {
        Day day = Day.MONDAY;
        System.out.println(day);

        if (day == Day.MONDAY) {
            System.out.println("Hello, Monday");
        }

        Day dayFromString = Day.valueOf("SATURDAY");
        System.out.println(dayFromString);
    }
}
