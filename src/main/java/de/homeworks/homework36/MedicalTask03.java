package de.homeworks.homework36;

import lombok.extern.slf4j.Slf4j;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Slf4j
public class MedicalTask03 {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {
        System.out.print("Время консультации для врача (dd.MM.yyyy HH:mm): ");
        String consultationTime = scanner.nextLine();
        try {
            LocalDateTime dateTimePatient = LocalDateTime.parse(consultationTime, FORMATTER);
            ZonedDateTime zonedDateTimePatient = dateTimePatient.atZone(ZoneId.of("Europe/Berlin"));

            ZoneId zonedId = ZoneId.of("America/New_York");

            System.out.println("Время консультации для пациента: " +
                    zonedDateTimePatient.withZoneSameInstant(zonedId).format(FORMATTER));
        } catch (DateTimeException exception) {
            log.error(exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
