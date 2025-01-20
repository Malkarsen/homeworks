package de.homeworks.homework31;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostOfficeTest {
    @Test
    void testAddMailItemIsSuccessful() {
        // Arrange
        PostOffice postOffice = new PostOffice();
        MailItem mailItem = new Letter("Anna", "Jane", 2.3, true);

        // Act
        postOffice.addMailItem(mailItem);
        List<MailItem> mailItems = postOffice.getMailItems();
        boolean isAdded = mailItems.contains(mailItem);

        // Assert
        assertTrue(isAdded);
    }

    @Test
    void testAddMailItemWhenObjectIsNull() {
        // Arrange
        PostOffice postOffice = new PostOffice();
        MailItem mailItem = null;

        // Act
        postOffice.addMailItem(mailItem);
        List<MailItem> mailItems = postOffice.getMailItems();
        boolean isAdded = mailItems.contains(mailItem);

        // Assert
        assertFalse(isAdded);
    }

    @Test
    void testAddMailItemWhenObjectIsInvalid() {
        // Arrange
        PostOffice postOffice = new PostOffice();
        MailItem mailItem = new Letter("Anna", null, -5, true);

        // Act
        postOffice.addMailItem(mailItem);
        List<MailItem> mailItems = postOffice.getMailItems();
        boolean isAdded = mailItems.contains(mailItem);

        // Assert
        assertFalse(isAdded);
    }

    @ParameterizedTest
    @CsvSource({
            "true, 5.7, 104, 14.93",
            "false, 3.8, 58, 8.06",
            "true, 1.5, 12, 10.75",
            "false, 2.9, 146, 9.37"
    })
    void testCalculateShippingCost(boolean isRegistered, double weight, int quantity, double expectedCost) {
        // Arrange
        PostOffice postOffice = new PostOffice();
        MailItem letter = new Letter("Anna", "Jane", 2.3, isRegistered);
        MailItem packageOne = new Package("Bob", "Alice", weight, 20, 30, 10);
        MailItem advertisement = new Advertisement("Charlie", "David", 1.2, quantity);
        postOffice.addMailItem(letter);
        postOffice.addMailItem(packageOne);
        postOffice.addMailItem(advertisement);

        // Act
        double shippingCost = postOffice.calculateTotalShippingCost();

        // Assert
        assertEquals(expectedCost, shippingCost, 0.01);
    }
}
