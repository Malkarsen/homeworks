package de.lessons.exceptions_unittest_lesson35;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlightBooking {
    public void bookFlight(String flightNumber, String passengerName, int seatNumber) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            log.error("Некорректный номер рейса: Номер рейса не может быть пустым или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректный номер рейса: Номер рейса не может быть пустым или равным нулю");
        }
        if (passengerName == null || passengerName.isEmpty()) {
            log.error("Некорректное имя пассажира: Имя пассажира не может быть пустым или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректное имя пассажира: Имя пассажира не может быть пустым или равным нулю");
        }
        if (seatNumber <= 0) {
            log.error("Некорректный номер места: Номер места не может быть отрицательным или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректный номер места: Номер места не может быть отрицательным или равным нулю");
        }
        log.info("Забронирован рейс: {} для пассажира: {} с местом: {}", flightNumber, passengerName, seatNumber);
        System.out.println("Забронирован рейс: " + flightNumber +
                " для пассажира: " + passengerName +
                " с местом: " + seatNumber);
    }
}
