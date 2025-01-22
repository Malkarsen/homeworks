package de.lessons.propertyApp_lesson32;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommercialPropertyTest {
    @ParameterizedTest
    @CsvSource({
            "300, Office, 300000.0",
            "30, Warehouse, 30000.0",
            "100, Office, 100000.0",
            "150, Warehouse, 150000.0",
            "70, Other, 70000.0"
    })
    void testCalculatePrice(double area, String businessType,
                            double expectedPrice) {
        // Arrange
        Property commercialProperty = new CommercialProperty("Office Street", area, businessType);

        // Act
        double price = commercialProperty.calculatePrice();

        // Assert
        assertEquals(expectedPrice, price, 0.01);
    }
}
