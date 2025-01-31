package de.lessons.exceptions_unittest_lesson35;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FlightBookingTest {
    private static Faker faker = null;
    private FlightBooking flightBooking = null;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        flightBooking = new FlightBooking();
    }

    @Test
    void testBookFlightSuccess() {
        assertDoesNotThrow(() -> flightBooking.bookFlight(
        "A201", faker.name().firstName(),  faker.number().randomDigitNotZero()));
    }

    @Test
    void testBookFlightFailFlightNumberIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> flightBooking.bookFlight(null, faker.name().lastName(), 10));
    }

    @Test
    void testBookFlightFailFlightNumberIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> flightBooking.bookFlight("", faker.name().lastName(), 10));
    }

    @Test
    void testBookFlightFailPassengerNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> flightBooking.bookFlight("ASD345", null, 10));
    }

    @Test
    void testBookFlightFailPassengerNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> flightBooking.bookFlight("ASD345", "", 10));
    }

    @Test
    void testBookFlightFailSeatNumberIs0() {
        assertThrows(IllegalArgumentException.class,
                () -> flightBooking.bookFlight("ASD345", faker.name().lastName(), 0));
    }
}
