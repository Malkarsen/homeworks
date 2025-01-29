package de.homeworks.homework34.task3;

import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystemManager {
    static HotelReservationSystem hotelReservationSystem = new HotelReservationSystem();

    public static void main(String[] args) {
        Map<Integer, String> roomMap = new HashMap<Integer, String>();
        roomMap.put(201, ""); // некорректные данные (имя)
        roomMap.put(102, null); // некорректные данные (имя)
        roomMap.put(0, "Charlie"); // некорректные данные (номер комнаты)
        roomMap.put(100, "Bob"); // некорректные данные (несуществующая комната)
        roomMap.put(101, "Alice"); // корректные данные

        for (int roomNumber : roomMap.keySet()) {
            reserveRoom(roomNumber, roomMap.get(roomNumber));
            System.out.println("------------");
            cancelReservation(roomNumber);
            System.out.println("----------------------------");
        }

        // обыкновенное бронирование
        reserveRoom(101, "Alice");
        // попытка забронировать уже занятую комнату
        reserveRoom(101, "Kris");

        System.out.println("----------------------------");

        // попытка отменить бронь на свободно комнате
        cancelReservation(102);
        // попытка отменить бронь на несуществующей комнате
        cancelReservation(300);
    }

    public static void reserveRoom(int roomNumber, String guestName) {
        try {
            hotelReservationSystem.reserveRoom(roomNumber, guestName);
        } catch (IllegalArgumentException exception) {
            System.out.println("Booking failed (Invalid reservation information): "
                    + exception.getMessage());
        } catch (RoomUnavailableException exception) {
            System.out.println("Booking failed (Room is unavailable): "
                    + exception.getMessage());
        }
    }

    public static void cancelReservation(int roomNumber) {
        try {
            hotelReservationSystem.cancelReservation(roomNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println("Cancellation failed (Invalid canceled information): "
                    + exception.getMessage());
        } catch (NoActiveReservationException exception) {
            System.out.println("Cancellation failed (The room is already free): "
                    + exception.getMessage());
        }
    }
}
