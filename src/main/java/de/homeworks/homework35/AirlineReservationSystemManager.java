package de.homeworks.homework35;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class AirlineReservationSystemManager {
    public static void main(String[] args) {
        Faker faker = new Faker();
        AirlineReservationSystem airlineReservationSystem = new AirlineReservationSystem();
        airlineReservationSystem.showInfo();

        List<BoardingPass> flights = new ArrayList<>();
        flights.add(new BoardingPass(null, faker.name().fullName(), 1)); // некорректный номер рейса
        flights.add(new BoardingPass("", faker.name().fullName(), 2)); // некорректный номер рейса
        flights.add(new BoardingPass("AB123", faker.name().fullName(), 0)); // некорректный номер места
        flights.add(new BoardingPass("AU123", null, 3)); // некорректный имя пассажира
        flights.add(new BoardingPass("BF345", "", 4)); // некорректный имя пассажира
        flights.add(new BoardingPass("RP845", faker.name().fullName(), 1)); // рейс отсутствует в списке
        flights.add(new BoardingPass("CQ678", faker.name().fullName(), 4)); // место отсутствует в списке
        flights.add(new BoardingPass("AU123", faker.name().fullName(), 2)); // место уже занято
        flights.add(new BoardingPass("BF345", faker.name().fullName(), 2)); // место ещё свободно

        for (BoardingPass flight : flights) {
            String flightNumber = flight.getFlightNumber();
            int seatNumber = flight.getSeatNumber();
            String passengerName = flight.getPassengerName();

            // Бронирование места
            try {
                airlineReservationSystem.reserveSeat(flightNumber, seatNumber, passengerName);
            } catch (IllegalArgumentException exception) {
                System.out.println("Бронирование не удалось (Неверные данные для бронирования): "
                        + exception.getMessage());
            } catch (SeatUnavailableException exception) {
                System.out.println("Бронирование не удалось (Место уже занято): "
                        + exception.getMessage());
            }
            System.out.println("---------------");
            // Отмена бронирования
            try {
                airlineReservationSystem.cancelReservation(flightNumber, seatNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println("Отмена бронирования не удалась (Неверные данные для отмены): "
                        + exception.getMessage());
            } catch (NoActiveReservationException exception) {
                System.out.println("Отмена бронирования не удалась (Место уже свободно): "
                        + exception.getMessage());
            }
            System.out.println("--------------------------------");
        }
    }
}
