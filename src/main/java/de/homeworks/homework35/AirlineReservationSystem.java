package de.homeworks.homework35;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AirlineReservationSystem {
    Faker faker = new Faker();
    // Option 1
    // String - номер рейса, Integer - номер места, Boolean - занятость места
    // private Map<String, Map<Integer, Boolean>> reservedFlightSeats;

    // Option 2
    // String - номер рейса, Integer - номер места, String - имя пассажира или null
    private Map<String, Map<Integer, String>> reservedFlightSeats;

    public AirlineReservationSystem() {
        this.reservedFlightSeats = new HashMap<>();

        // Option 1
//        addFlightWithOneSeat("AU123", 1, false);
//        addFlightWithOneSeat("AU123", 2, true);
//        addFlightWithOneSeat("AU123", 3, false);
//
//        addFlightWithOneSeat("BF345", 1, true);
//        addFlightWithOneSeat("BF345", 2, false);
//        addFlightWithOneSeat("BF345", 3, true);
//
//        addFlightWithOneSeat("CQ678", 1, false);
//        addFlightWithOneSeat("CQ678", 2, true);
//        addFlightWithOneSeat("CQ678", 3, true);

        // Option 2
        addFlightWithOneSeat("AU123", 1, null);
        addFlightWithOneSeat("AU123", 2, faker.name().fullName());
        addFlightWithOneSeat("AU123", 3, null);

        addFlightWithOneSeat("BF345", 1, faker.name().fullName());
        addFlightWithOneSeat("BF345", 2, null);
        addFlightWithOneSeat("BF345", 3, faker.name().fullName());

        addFlightWithOneSeat("CQ678", 1, null);
        addFlightWithOneSeat("CQ678", 2, faker.name().fullName());
        addFlightWithOneSeat("CQ678", 3, faker.name().fullName());
    }

    public HashMap<String, Map<Integer, String>> getReservedFlightSeats() {
        return new HashMap<> (reservedFlightSeats);
    }

    public void addFlightWithLotsOfSeats(String flightNumber, HashMap<Integer, String> seats) {
        if (flightNumber != null && !flightNumber.isEmpty()
                && isFlightNumberValid(flightNumber) && seats != null && !seats.isEmpty()) {
            reservedFlightSeats.put(flightNumber, seats);
        }
    }

    public void addFlightWithOneSeat(String flightNumber, int seatNumber, String passengerName) {
        if (flightNumber != null && !flightNumber.isEmpty()
                && isFlightNumberValid(flightNumber) && seatNumber > 0) {
            if (!reservedFlightSeats.containsKey(flightNumber)) {
                reservedFlightSeats.put(flightNumber, new HashMap<>());
            }
            reservedFlightSeats.get(flightNumber).put(seatNumber, passengerName);
        } else {
            log.error("Некорректные данные: в веденных данных содержится ошибка");
            throw new IllegalArgumentException(
                    "Некорректные данные: в веденных данных содержится ошибка");
        }
    }

    public void reserveSeat(String flightNumber, int seatNumber, String passengerName)
            throws SeatUnavailableException {
        if (flightNumber == null || flightNumber.isEmpty()) {
            log.error("Некорректный номер рейса: Номер рейса не может быть пустым или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректный номер рейса: Номер рейса не может быть пустым или равным нулю");
        }
        if (seatNumber <= 0) {
            log.error("Некорректный номер места: Номер места не может быть отрицательным или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректный номер места: Номер места не может быть отрицательным или равным нулю");
        }
        if (passengerName == null || passengerName.isEmpty()) {
            log.error("Некорректное имя пассажира: Имя пассажира не может быть пустым или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректное имя пассажира: Имя пассажира не может быть пустым или равным нулю");
        }
        if (!reservedFlightSeats.containsKey(flightNumber)) {
            log.error("Рейс {} не найден", flightNumber);
            throw new IllegalArgumentException("Рейс " + flightNumber + " не найден");
        }
        if (!reservedFlightSeats.get(flightNumber).containsKey(seatNumber)) {
            log.error("Место {} не найдено", seatNumber);
            throw new IllegalArgumentException("Место " + seatNumber + " не найдено");
        }
        // Option 1
//        if (reservedFlightSeats.get(flightNumber).get(seatNumber)) {
//            log.error("Место {} уже занято", flightNumber);
//            throw new SeatUnavailableException("Место " + flightNumber + " уже занято");
//        }
        // Option 2
        if (reservedFlightSeats.get(flightNumber).get(seatNumber)!= null) {
            log.error("Место {} уже занято", seatNumber);
            throw new SeatUnavailableException("Место " + seatNumber + " уже занято");
        }
        log.info("Забронировано место {} на рейсе {} для пассажира: {}",
                seatNumber, flightNumber, passengerName);
        System.out.println("Забронировано место " + seatNumber +
                " на рейсе " + flightNumber + " для пассажира: " + passengerName);
        // Option 1
//        reservedFlightSeats.get(flightNumber).put(seatNumber, true);
        // Option 2
        reservedFlightSeats.get(flightNumber).put(seatNumber, passengerName);
    }

    public void cancelReservation(String flightNumber, int seatNumber)
            throws NoActiveReservationException {
        if (flightNumber == null || flightNumber.isEmpty()) {
            log.error("Некорректный номер рейса: Номер рейса не может быть пустым или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректный номер рейса: Номер рейса не может быть пустым или равным нулю");
        }
        if (seatNumber <= 0) {
            log.error("Некорректный номер места: Номер места не может быть отрицательным или равным нулю");
            throw new IllegalArgumentException(
                    "Некорректный номер места: Номер места не может быть отрицательным или равным нулю");
        }
        if (!reservedFlightSeats.containsKey(flightNumber)) {
            log.error("Рейс {} не найден", flightNumber);
            throw new IllegalArgumentException("Рейс " + flightNumber + " не найден");
        }
        if (!reservedFlightSeats.get(flightNumber).containsKey(seatNumber)) {
            log.error("Место {} не найдено", seatNumber);
            throw new IllegalArgumentException("Место " + seatNumber + " не найдено");
        }
        // Option 1
//        if (!reservedFlightSeats.get(flightNumber).get(seatNumber)) {
//            log.error("Место {} уже свободно", flightNumber);
//            throw new NoActiveReservationException("Место " + flightNumber + " уже свободно");
//        }
        // Option 2
        if (reservedFlightSeats.get(flightNumber).get(seatNumber) == null) {
            log.error("Место {} уже свободно", seatNumber);
            throw new NoActiveReservationException("Место " + seatNumber + " уже свободно");
        }
        log.info("Место {} на рейсе {} теперь не занято",
                seatNumber, flightNumber);
        System.out.println("Место " + seatNumber +
                " на рейсе " + flightNumber + " теперь не занято ");
        // Option 1
//        reservedFlightSeats.get(flightNumber).put(seatNumber, false);
        // Option 2
        reservedFlightSeats.get(flightNumber).put(seatNumber, null);
    }

    public void showInfo() {
        for (String flightNumber : reservedFlightSeats.keySet()) {
            Map<Integer, String> seats = reservedFlightSeats.get(flightNumber);
            System.out.println("Рейс: " + flightNumber);
            for (int seatNumber : seats.keySet()) {
                String passengerName = seats.get(seatNumber);
                if (passengerName!= null) {
                    System.out.println("\tМесто " + seatNumber + " занято: " + passengerName);
                } else {
                    System.out.println("\tМесто " + seatNumber + " свободно");
                }
            }
        }
    }

    private boolean isFlightNumberValid(String flightNumber) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            return false;
        }
        return flightNumber.matches("^[A-Z]{2}\\d{1,4}");
    }
}
