package de.lessons.enum_lesson33;

public class SeasonApp {
    public static void main(String[] args) {
        Season summer = Season.SUMMER;
        System.out.println("Season: " + summer);
        System.out.println("Average temp: " + summer.getAverageTemperature());

        Season winter = Season.WINTER;
        System.out.println("Season: " + winter);
        System.out.println("Average temp: " + winter.getAverageTemperature());

        Season springSeason = Season.valueOf("SPRING");

        switch (springSeason) {
            case SPRING:
                System.out.println("It's spring");
                break;
            case SUMMER:
                System.out.println("It's summer");
                break;
            case FALL:
                System.out.println("It's fall");
                break;
            case WINTER:
                System.out.println("It's winter");
                break;
            default:
                System.out.println("Invalid season");
                break;
        }

        for (Season season : Season.values()) {
            System.out.println("Season: " + season);
        }
    }
}
