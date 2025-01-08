package de.homeworks.homework27;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DepartmentTest {
    private Department departmentIT;

    @BeforeEach
    void setUp() {
        departmentIT = new Department("IT");
    }

    @Test
    void testAddEmployeeSuccessful() {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        Employee employee3 = new Employee("3","Tom","Junior developer", 25000);

        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);
        departmentIT.addEmployee(employee3);

        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        assertEquals(3, employeesResult.size());
        assertEquals(employee, employeesResult.get(0));
        assertEquals(employee2, employeesResult.get(1));
        assertEquals(employee3, employeesResult.get(2));
    }

    @Test
    void testAddNullEmployee() {
        Employee employee = null;
        departmentIT.addEmployee(employee);
        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        assertEquals(0, employeesResult.size());
    }

    @Test
    void testAddEmployeeWithEmptyFields() {
        Employee employee = new Employee(null,"Doe","Junior developer", 35000);
        departmentIT.addEmployee(employee);
        ArrayList<Employee> employeesResult = departmentIT.getEmployees();
        assertEquals(0, employeesResult.size());

        Employee employee2 = new Employee("1",null,"Junior developer", 35000);
        departmentIT.addEmployee(employee2);
        ArrayList<Employee> employeesResult2 = departmentIT.getEmployees();
        assertEquals(0, employeesResult2.size());

        Employee employee3 = new Employee("1","Doe",null, 35000);
        departmentIT.addEmployee(employee3);
        ArrayList<Employee> employeesResult3 = departmentIT.getEmployees();
        assertEquals(0, employeesResult3.size());

        Employee employee4 = new Employee("1","Doe","Junior developer", -200);
        departmentIT.addEmployee(employee4);
        ArrayList<Employee> employeesResult4 = departmentIT.getEmployees();
        assertEquals(0, employeesResult4.size());
    }

    @Test
    public void testGetterWasSuccessful() {
        Employee employee = new Employee(null,"Doe","Junior developer", 35000);
        departmentIT.addEmployee(employee);
        String resultDepartmentName = departmentIT.getName();
        assertEquals("IT", resultDepartmentName);
    }

    @Test
    void testGetTotalSalaryIfEmployeeIsNull() {
        Employee employee = null;
        departmentIT.addEmployee(employee);
        double totalSalary = departmentIT.getTotalSalary();
        assertEquals(0, totalSalary);
    }

    @Test
    void testGetTotalSalaryWasSuccessful() {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);
        double totalSalary = departmentIT.getTotalSalary();
        assertEquals(85000, totalSalary);
    }

    @Test
    void testRemoveEmployeeWithNullAndEmptyId() {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);

        int sizeBeforeNull = departmentIT.getEmployees().size();
        departmentIT.removeEmployee(null);
        int sizeAfterNull = departmentIT.getEmployees().size();
        assertEquals(sizeAfterNull, sizeBeforeNull);

        int sizeBeforeEmpty = departmentIT.getEmployees().size();
        departmentIT.removeEmployee("");
        int sizeAfterEmpty = departmentIT.getEmployees().size();
        assertEquals(sizeAfterEmpty, sizeBeforeEmpty);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 2",
            "2, 1"
    })
    void testRemoveEmployeeWhenIdIdDifferent(String initial, int expected) {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);

        departmentIT.removeEmployee(initial);
        int sizeAfter = departmentIT.getEmployees().size();
        assertEquals(expected, sizeAfter);
    }

    @Test
    void testFindEmployeeWithNullAndEmptyId() {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);

        Employee resultWithNull = departmentIT.findEmployee(null);
        assertNull(resultWithNull);
        Employee resultWithEmpty = departmentIT.findEmployee("");
        assertNull(resultWithEmpty);
    }

    @Test
    void testFindEmployeeWhenIdIsDifferent() {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);

        Employee resultEmployee = departmentIT.findEmployee("2");
        assertEquals(employee2, resultEmployee);
        Employee resultEmployee2 = departmentIT.findEmployee("3");
        assertNull(resultEmployee2);
    }
}
