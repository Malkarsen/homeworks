package de.homeworks.homework34.task3;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelReservationSystemTest {
    private static Faker faker = null;
    private HotelReservationSystem hotelReservationSystem = null;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        hotelReservationSystem = new HotelReservationSystem();
    }

    @Test
    void testReserveRoomSuccess() {
        assertDoesNotThrow( () -> hotelReservationSystem.reserveRoom(
                101, faker.name().firstName()));
    }

    @Test
    void testReserveRoomFailNegativeRoomNumber() {
        assertThrows( IllegalArgumentException.class,
                () -> hotelReservationSystem.reserveRoom(-1, faker.name().firstName()));
    }

    @Test
    void testReserveRoomFailZeroRoomNumber() {
        assertThrows( IllegalArgumentException.class,
                () -> hotelReservationSystem.reserveRoom(0, faker.name().firstName()));
    }

    @Test
    void testReserveRoomFailGuestNameIsNull() {
        assertThrows( IllegalArgumentException.class,
                () -> hotelReservationSystem.reserveRoom(102, null));
    }

    @Test
    void testReserveRoomFailGuestNameIsEmpty() {
        assertThrows( IllegalArgumentException.class,
                () -> hotelReservationSystem.reserveRoom(103, ""));
    }

    @Test
    void testReserveRoomFailRoomIsNotInList() {
        assertThrows( IllegalArgumentException.class,
                () -> hotelReservationSystem.reserveRoom(105, faker.name().firstName()));
    }

    @Test
    void testReserveRoomFailRoomIsYetBooked() {
        try {
            hotelReservationSystem.reserveRoom(101, faker.name().firstName());
        } catch (RoomUnavailableException exception) {
            System.out.println("Booking failed (Room is unavailable): "
                    + exception.getMessage());
        }

        assertThrows( RoomUnavailableException.class,
                () -> hotelReservationSystem.reserveRoom(101, faker.name().firstName()));
    }

    @Test
    void testCancelReservationSuccess() {
        try {
            hotelReservationSystem.reserveRoom(101, faker.name().firstName());
        } catch (RoomUnavailableException exception) {
            System.out.println("Booking failed (Room is unavailable): "
                    + exception.getMessage());
        }
        assertDoesNotThrow( () -> hotelReservationSystem.cancelReservation(101));
    }

    @Test
    void testCancelReservationFailRoomIsNotInList() {
        assertThrows( IllegalArgumentException.class,
                () -> hotelReservationSystem.cancelReservation(105));
    }

    @Test
    void testCancelReservationFailRoomIsYetCanceled() {
        assertThrows( NoActiveReservationException.class,
                () -> hotelReservationSystem.cancelReservation(101));
    }
}
