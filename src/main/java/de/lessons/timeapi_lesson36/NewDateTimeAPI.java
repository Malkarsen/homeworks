package de.lessons.timeapi_lesson36;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NewDateTimeAPI {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);

        LocalDate manuelDate = LocalDate.of(2020, 12, 04);
        System.out.println("Manuel date: " + manuelDate);

        int year = manuelDate.getYear();
        int month = manuelDate.getMonthValue();
        int day = manuelDate.getDayOfMonth();
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);

        manuelDate = manuelDate.plusDays(10);
        System.out.println("Manuel date after 10 days: " + manuelDate);
        manuelDate = manuelDate.plusMonths(2);
        System.out.println("Manuel date after 2 months: " + manuelDate);
        manuelDate = manuelDate.minusDays(100);
        System.out.println("Manuel date after subtracting 100 days: " + manuelDate);

        // ----------------------------------------------------------------
        LocalTime localTime = LocalTime.now();
        System.out.println("Local time: " + localTime);

        LocalTime manuelTime = LocalTime.of(22, 00, 00);
        System.out.println("Manuel time: " + manuelTime);
        manuelTime = manuelTime.plusHours(1);
        System.out.println("Manuel time after 1 hour: " + manuelTime);

        // ----------------------------------------------------------------

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);

        LocalDateTime manuelDateTime = LocalDateTime.of(2020, 1, 12, 14, 00);
        System.out.println("Manuel date and time: " + manuelDateTime);
        manuelDateTime = manuelDateTime.plusHours(1);
        System.out.println("Manuel date and time after 1 hour: " + manuelDateTime);

        // ----------------------------------------------------------------

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Zoned date and time: " + zonedDateTime);

        ZonedDateTime zoneIdZonedDateTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Manuel date and time in Los Angeles: " + zoneIdZonedDateTime);

        // ----------------------------------------------------------------

        Instant instant = Instant.now();
        System.out.println("Current instant: " + instant);

        // ----------------------------------------------------------------

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local date time --> " + localDateTime);
        DateTimeFormatter isoFormater = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = localDateTime.format(isoFormater);
        System.out.println("Formatted date time (ISO): " + formattedDateTime);

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTimeCustom = localDateTime.format(customFormatter);
        System.out.println("Formatted date time (custom): " + formattedDateTimeCustom);

        // ----------------------------------------------------------------

        String inputUser = "04.02.2000";
        DateTimeFormatter formatterUser = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateUser = LocalDate.parse(inputUser, formatterUser);
        if (LocalDate.now().getYear() - localDateUser.getYear() < 18) {
            System.out.println("You are too young");
        } else {
            System.out.println("Ok");
        }

        // ----------------------------------------------------------------

        LocalDate startDate = LocalDate.of(2024, 9, 9);
        LocalDate endDate = LocalDate.now();

        Period period = Period.between(startDate, endDate);
        System.out.println("Period in months: " + period.getMonths());
        System.out.println("Period in days: " + period.getDays());
        System.out.println("Period in years: " + period.getYears());

        Duration duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay());
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println("Duration in minutes: " + duration.toMinutes());
        System.out.println("Duration in millis: " + duration.toMillis());
    }
}
