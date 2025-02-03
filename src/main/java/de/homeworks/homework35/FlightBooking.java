package de.homeworks.homework35;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlightBooking {
    private String[] flights = {"SU100", "BA202", "LH300", "AF101", "AA777"};
    private String[] passengers = new String[5];

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

    public void addPassenger(int flightIndex, String passengerName) {
        if (flightIndex < 0 || flightIndex >= flights.length) {
            log.error("Индекс полёта находится вне границ массива");
            throw new ArrayIndexOutOfBoundsException("Индекс полёта находится вне границ массива");
        }
        if (passengerName == null || passengerName.isEmpty()) {
            log.error("Некорректное имя пассажира: Имя пассажира не может быть пустым или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректное имя пассажира: Имя пассажира не может быть пустым или равным нулю");
        }
        log.info("Добавлен пассажир: {} на рейс: {}", passengerName, flights[flightIndex]);
        System.out.println("Добавлен пассажир: " + passengerName + " на рейс: " + flights[flightIndex]);
        passengers[flightIndex] = passengerName;
    }

    public String getPassenger(int flightIndex) throws NoPassengerException{
        if (flightIndex < 0 || flightIndex >= flights.length) {
            log.error("Индекс полёта находится вне границ массива");
            throw new ArrayIndexOutOfBoundsException("Индекс полёта находится вне границ массива");
        }
        if (passengers[flightIndex] == null) {
            log.error("Пассажир не забронирован на рейсе: {}", flights[flightIndex]);
            throw new NoPassengerException("Пассажир не забронирован на рейсе: " + flights[flightIndex]);
        }
        String passengerName = passengers[flightIndex];
        log.info("Пассажир: {} на рейсе: {}", passengerName, flights[flightIndex]);
        System.out.println("Пассажир: " + passengerName + " на рейсе: " + flights[flightIndex]);
        return passengerName;
    }
}
