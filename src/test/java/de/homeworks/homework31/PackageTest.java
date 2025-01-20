package de.homeworks.homework31;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageTest {
    @ParameterizedTest
    @CsvSource({
            "5, 2.5",
            "4.6, 2.3",
            "2.9, 1.45",
            "3.5, 1.75",
            "0, 0"
    })
    void testCalculateShippingCostWhenPackageWeightIsDifferent(double weight, double expectedShippingCost) {
        // Arrange
        MailItem packageOne = new Package("Bob", "Alice", weight, 20, 30, 10);

        // Act
        double shippingCost = packageOne.calculateShippingCost();

        // Assert
        assertEquals(expectedShippingCost, shippingCost);
    }
}
