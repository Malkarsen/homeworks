package de.homeworks.homework35;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FlightBookingManager {
    public static void main(String[] args) {
        Faker faker = new Faker();
        FlightBooking flightBooking = new FlightBooking();

        // Task 1
        List<BoardingPass> passengers = new ArrayList<BoardingPass>();
        passengers.add(new BoardingPass("UA123", faker.name().lastName(), 100));
        passengers.add(new BoardingPass("", faker.name().lastName(), 56));
        passengers.add(new BoardingPass(null, faker.name().lastName(), 23));
        passengers.add(new BoardingPass("TU054", "", 14));
        passengers.add(new BoardingPass("PW721", null, 62));
        passengers.add(new BoardingPass("OE001", faker.name().lastName(), 0));

        for (BoardingPass passenger : passengers) {
            try {
                flightBooking.bookFlight(passenger.getFlightNumber(), passenger.getPassengerName(), passenger.getSeatNumber());
            } catch (IllegalArgumentException exception) {
                System.out.println("Ошибка бронирования, некорректные данные: " + exception.getMessage());
                log.error("Ошибка бронирования, некорректные данные: {}", exception.getMessage());
                log.error(Arrays.stream(exception.getStackTrace()).toString());
            }
        }

        // Task 2
        Map<Integer, String> passengers2 = new HashMap<>();
        passengers2.put(-1, faker.name().lastName());
        passengers2.put(6, faker.name().lastName());
        passengers2.put(0, null);
        passengers2.put(1, "");
        passengers2.put(2, faker.name().lastName());

        for (int flightIndex : passengers2.keySet()) {
            String passengerName = passengers2.get(flightIndex);
            try {
                flightBooking.addPassenger(flightIndex, passengerName);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Ошибка добавления пассажира, некорректный номер полёта: " + exception.getMessage());
                log.error("Ошибка добавления пассажира, некорректный номер полёта: {}", exception.getMessage());
                log.error(Arrays.stream(exception.getStackTrace()).toString());
            } catch (IllegalArgumentException exception) {
                System.out.println("Ошибка добавления пассажира, пользователь не зарегистрирован на рейсе: "
                        + exception.getMessage());
                log.error("Ошибка добавления пассажира, пользователь не зарегистрирован на рейсе: {}",
                        exception.getMessage());
                log.error(Arrays.stream(exception.getStackTrace()).toString());
            }
        }

        // Task 3
    }
}
