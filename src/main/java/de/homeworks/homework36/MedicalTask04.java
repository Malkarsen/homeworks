package de.homeworks.homework36;

import lombok.extern.slf4j.Slf4j;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Slf4j
public class MedicalTask04 {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        System.out.print("Введите дату рождения пациента (dd.MM.yyyy): ");
        String dateOfBirthInputString = scanner.nextLine();
        try {
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthInputString, FORMATTER);
            LocalDate currentDate = LocalDate.now();

            Period period = Period.between(dateOfBirth, currentDate);
            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();

            System.out.printf("Возраст пациента: " + years + " лет, "
                    + months + " месяцев, " + days + " дней.");
        } catch (DateTimeException exception) {
            log.error(exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
