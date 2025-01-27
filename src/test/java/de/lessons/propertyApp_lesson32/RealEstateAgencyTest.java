package de.lessons.propertyApp_lesson32;

import de.homeworks.homework31.Advertisement;
import de.homeworks.homework31.Letter;
import de.homeworks.homework31.MailItem;
import de.homeworks.homework31.Package;
import de.homeworks.homework31.PostOffice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealEstateAgencyTest {
    @Test
    void testAddPropertyIsSuccessful() {
        // Arrange
        RealEstateAgency realEstateAgency = new RealEstateAgency();
        Property house = new House("House Street", 200, 200, false);

        // Act
        realEstateAgency.addProperty(house);
        List<Property> properties = realEstateAgency.getProperties();
        boolean isAdded = properties.contains(house);

        // Assert
        assertTrue(isAdded);
    }

    @Test
    void testAddMailItemWhenObjectIsNull() {
        // Arrange
        RealEstateAgency realEstateAgency = new RealEstateAgency();
        Property house = null;

        // Act
        realEstateAgency.addProperty(house);
        List<Property> properties = realEstateAgency.getProperties();
        boolean isAdded = properties.contains(house);

        // Assert
        assertFalse(isAdded);
    }

    @ParameterizedTest
    @CsvSource({
            "100, true, 200, 200, false, 300, 30, 635000.0",
            "50, false, 100, 100, false, 150, 20, 320000.0",
            "150, true, 150, 150, true, 200, 10, 522500.0",
            "200, false, 100, 100, true, 150, 20, 475000.0",
            "250, true, 100, 100, false, 150, 20, 532500.0"
    })
    void testCalculateTotalPrice(double apartmentArea, boolean hasElevator,
                                 double houseArea, double landArea, boolean hasGarage,
                                 double officeArea, double warehouseArea,
                                 double expectedCost) {
        // Arrange
        RealEstateAgency realEstateAgency = new RealEstateAgency();
        Property apartment = new Apartment("Main street", 4, apartmentArea, hasElevator);
        Property house = new House("House Street", houseArea, landArea, hasGarage);
        Property office = new CommercialProperty("Office Street", officeArea, "Office");
        Property warehouse = new CommercialProperty("Warehouse Street", warehouseArea, "Warehouse");
        realEstateAgency.addProperty(apartment);
        realEstateAgency.addProperty(house);
        realEstateAgency.addProperty(office);
        realEstateAgency.addProperty(warehouse);

        // Act
        realEstateAgency.calculateTotalPrice();
        double totalPrice = realEstateAgency.getTotalPrice();

        // Assert
        assertEquals(expectedCost, totalPrice, 0.01);
    }

}
