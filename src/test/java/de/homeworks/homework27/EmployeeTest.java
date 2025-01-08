package de.homeworks.homework27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeTest {
    @Test
    public void testEmployeeCreateAndGetterSettersWereSuccessful() {
        Employee employee = new Employee("1", "Doe", "Junior developer", 35000);
        assertNotNull(employee);
        String resultId = employee.getId();
        assertEquals("1", resultId);
        String resultName = employee.getName();
        assertEquals("Doe", resultName);
        String resultPosition = employee.getPosition();
        assertEquals("Junior developer", resultPosition);
        double resultSalary = employee.getSalary();
        assertEquals(35000, resultSalary);

        employee.setName("John");
        String newName = employee.getName();
        assertEquals("John", newName);

        employee.setPosition("Senior developer");
        String newPosition = employee.getPosition();
        assertEquals("Senior developer", newPosition);

        employee.setSalary(40000);
        double newSalary = employee.getSalary();
        assertEquals(40000, newSalary);
    }

    @Test
    void testGetInfo() {
        Employee employee = new Employee("1", "Doe", "Junior developer", 35000);
        String resultInfo = employee.getInfo();
        assertEquals("Employee{id='1', name='Doe', position='Junior developer', salary=35000.0}", resultInfo);
    }
}
