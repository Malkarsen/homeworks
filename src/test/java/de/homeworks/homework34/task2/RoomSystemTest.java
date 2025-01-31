package de.homeworks.homework34.task2;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomSystemTest {
    private static Faker faker = null;
    private RoomSystem roomSystem = null;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        roomSystem = new RoomSystem();
    }

    @Test
    void testAddGuestSuccess() {
        assertDoesNotThrow( () -> roomSystem.addGuest(101, faker.name().firstName()));
    }

    @Test
    void testAddGuestFailInvalidRoomIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> roomSystem.addGuest(-1, faker.name().firstName()));
    }

    @Test
    void testAddGuestFailGuestNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> roomSystem.addGuest(101, null));
    }

    @Test
    void testAddGuestFailGuestNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> roomSystem.addGuest(101, ""));
    }

    @Test
    void testGetGuestSuccess() {
        roomSystem.addGuest(101, faker.name().firstName());
        assertDoesNotThrow( () -> roomSystem.getGuest(101));
    }
}
