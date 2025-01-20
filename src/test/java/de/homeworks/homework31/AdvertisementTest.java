package de.homeworks.homework31;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvertisementTest {
    @ParameterizedTest
    @CsvSource({
            "5, 0",
            "104, 2.08",
            "-1, 0",
            "156, 3.12",
            "0, 0"
    })
    void testCalculateShippingCostWhenPackageWeightIsDifferent(int quantity, double expectedShippingCost) {
        // Arrange
        MailItem advertisement = new Advertisement("Charlie", "David", 1.2, quantity);

        // Act
        double shippingCost = advertisement.calculateShippingCost();

        // Assert
        assertEquals(expectedShippingCost, shippingCost);
    }
}
