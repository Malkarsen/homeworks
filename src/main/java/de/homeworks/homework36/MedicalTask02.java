package de.homeworks.homework36;

import lombok.extern.slf4j.Slf4j;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Slf4j
public class MedicalTask02 {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {
        System.out.print("Дата и время операции (dd.MM.yyyy HH:mm): ");
        String operationDateInputString = scanner.nextLine();

        try {
            LocalDateTime operationDateInput = LocalDateTime.parse(operationDateInputString, FORMATTER);
            LocalDateTime currentDatetime = LocalDateTime.now();
            if (operationDateInput.isBefore(currentDatetime)) {
                log.error("Дата операции уже в прошлом. Расчёт времени невозможен. {}", operationDateInput);
                throw new DateTimeException("Дата операции ужк в прошлом. Расчёт времени невозможен. "
                        + operationDateInput);
            } else {
                Duration duration = Duration.between(currentDatetime, operationDateInput);
                long days = duration.toDays();
                long hours = duration.toHours() % 24;
                long minutes = duration.toMinutes() % 60;

                System.out.println("До операции осталось: " + days + " дней, "
                        + hours + " часов и " + minutes + " минут");
            }
        } catch (DateTimeException exception) {
            log.error(exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
