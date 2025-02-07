package de.homeworks.homework36;

import lombok.extern.slf4j.Slf4j;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Slf4j
public class MedicalTask05 {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public static void main(String[] args) {
        System.out.print("Дата производства (dd MMMM yyyy): ");
        String dayOfProduction = scanner.nextLine();
        try {
            LocalDate dayOfProductionLocalDate = LocalDate.parse(dayOfProduction, FORMATTER);

            System.out.print("Срок хранения (количество месяцев): ");
            int storagePeriod = scanner.nextInt();
            scanner.nextLine();
            if (storagePeriod <= 0) {
                throw new IllegalArgumentException("Срок хранения не может быть меньше или равен нулю");
            }

            LocalDate endDate = dayOfProductionLocalDate.plusMonths(storagePeriod);
            System.out.println("Лекарство годно до: " + endDate.format(FORMATTER));

            if (LocalDate.now().isAfter(endDate)) {
                System.out.println("Статус: ЛЕКАРСТВО ПРОСРОЧЕНО!");
            } else {
                System.out.println("Статус: Лекарство не просрочено");
            }
        } catch (IllegalArgumentException | DateTimeException exception) {
            log.error(exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
