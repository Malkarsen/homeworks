package de.lessons.propertyApp_lesson32;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApartmentTest {
    @ParameterizedTest
    @CsvSource({
            "100, true, 105000.0",
            "50, false, 50000.0",
            "150, true, 157500.0",
            "200, false, 200000.0",
            "250, true, 262500.0"
    })
    void testCalculatePrice(double apartmentArea, boolean hasElevator,
                                 double expectedPrice) {
        // Arrange
        Property apartment = new Apartment("Main street", 4, apartmentArea, hasElevator);

        // Act
        double price = apartment.calculatePrice();

        // Assert
        assertEquals(expectedPrice, price, 0.01);
    }
}
