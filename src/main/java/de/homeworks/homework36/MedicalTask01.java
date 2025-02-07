package de.homeworks.homework36;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@Slf4j
public class MedicalTask01 {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter VISIT_FORMATER = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public static void main(String[] args) {
        System.out.print("Введите дату последнего визита (dd.MM.yyyy): ");
        String lastVisitDate = scanner.nextLine();
        LocalDate lastVisitDateLocalDate = null;
        LocalDate newVisitDateLocalDate = null;
        boolean weekend = false;
        String formatedNextVisit = null;

        try {
            lastVisitDateLocalDate = LocalDate.parse(lastVisitDate, FORMATTER);
            newVisitDateLocalDate = lastVisitDateLocalDate.plusMonths(6);

            if (newVisitDateLocalDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
                newVisitDateLocalDate = newVisitDateLocalDate.plusDays(2);
                weekend = true;
            } else if (newVisitDateLocalDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                newVisitDateLocalDate = newVisitDateLocalDate.plusDays(1);
                weekend = true;
            }
            formatedNextVisit = newVisitDateLocalDate.format(VISIT_FORMATER);
        } catch (DateTimeParseException | NullPointerException exception) {
            log.error(exception.getMessage());
        } finally {
            scanner.close();
        }
        if (lastVisitDateLocalDate != null) {
            System.out.print("Дата следующего визита: " + formatedNextVisit);
            if (weekend) {
                System.out.println(" (перенесено с выходного)");
            }
        }
    }
}
