package de.homeworks.homework31;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterTest {
    @Test
    void testCalculateShippingCostWhenLetterIsRegistered() {
        // Arrange
        MailItem letter = new Letter("Anna", "Jane", 2.3, true);

        // Act
        double shippingCost = letter.calculateShippingCost();

        // Assert
        assertEquals(10, shippingCost);
    }

    @Test
    void testCalculateShippingCostWhenLetterIsNotRegistered() {
        // Arrange
        MailItem letter = new Letter("Anna", "Jane", 2.3, false);

        // Act
        double shippingCost = letter.calculateShippingCost();

        // Assert
        assertEquals(5, shippingCost);
    }
}
