package de.lessons.propertyApp_lesson32;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseTest {
    @ParameterizedTest
    @CsvSource({
            "200, 200, false, 200000.0",
            "100, 100, false, 100000.0",
            "150, 150, true, 155000.0",
            "100, 100, true, 105000.0",
            "210, 100, false, 188000.0"
    })
    void testCalculatePrice(double houseArea, double landArea, boolean hasGarage,
                            double expectedPrice) {
        // Arrange
        Property house = new House("House Street", houseArea, landArea, hasGarage);

        // Act
        double price = house.calculatePrice();

        // Assert
        assertEquals(expectedPrice, price, 0.01);
    }
}
