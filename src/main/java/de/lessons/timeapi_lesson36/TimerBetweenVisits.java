package de.lessons.timeapi_lesson36;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimerBetweenVisits {
    public static void main(String[] args) {
        // Задача
        // У пациента было два визита к врачу в разное время.
        // Нужно вычислить, сколько прошло времени (дней, часов, минут) между этими визитами.

        LocalDateTime firstVisit = LocalDateTime.of(2025, 1, 15, 9, 00);
        LocalDateTime lastVisit = LocalDateTime.of(2025, 2, 4, 10, 00);

        Duration duration = Duration.between(firstVisit, lastVisit);
        System.out.println("Days between visits: " + duration.toDays());
        System.out.println("Hours between visits: " + duration.toHours());
        System.out.println("Minutes between visits: " + duration.toMinutes());
    }
}
