package de.homeworks.homework27;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BusinessTest {
    @Test
    void testAddDepartmentWasSuccessful() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        Employee employee2 = new Employee("3", "tOM", "Junior developer", 25000);

        Department departmentIT = new Department("IT");
        departmentIT.addEmployee(employee1);
        departmentIT.addEmployee(employee2);

        Business business = new Business("CompIT");
        business.addDepartment(departmentIT);
        Department resultDepartment = business.getDepartment("IT");
        assertEquals(departmentIT, resultDepartment);
    }

    @Test
    void testAddDepartmentWhenDepartmentIsNull() {
        Department departmentIT = null;

        Business business = new Business("CompIT");
        business.addDepartment(departmentIT);
        HashMap<String, Department> employeesResult = business.getDepartments();
        assertEquals(0, employeesResult.size());
    }

    @Test
    void testRemoveDepartmentWhenDepartmentNameIsDifferent() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        Employee employee2 = new Employee("3", "tOM", "Junior developer", 25000);

        Department departmentIT = new Department("IT");
        departmentIT.addEmployee(employee1);
        departmentIT.addEmployee(employee2);

        Business business = new Business("CompIT");
        business.addDepartment(departmentIT);

        business.removeDepartment(null);
        HashMap<String, Department> employeesResult = business.getDepartments();
        assertEquals(1, employeesResult.size());

        business.removeDepartment("");
        HashMap<String, Department> employeesResult2 = business.getDepartments();
        assertEquals(1, employeesResult2.size());

        business.removeDepartment("HR");
        HashMap<String, Department> employeesResult3 = business.getDepartments();
        assertEquals(1, employeesResult3.size());

        business.removeDepartment("IT");
        HashMap<String, Department> employeesResult4 = business.getDepartments();
        assertEquals(0, employeesResult4.size());
    }

    @Test
    void testGetDepartmentWhenDepartmentNameIsNotFoundOrNullOrEmpty() {
        Business business = new Business("CompIT");

        Department resultDepartment = business.getDepartment(null);
        assertNull(resultDepartment);

        Department resultDepartment2 = business.getDepartment("");
        assertNull(resultDepartment2);

        Department resultDepartment3 = business.getDepartment("HR");
        assertNull(resultDepartment3);
    }

    @Test
    void testGetAllPositionsWasSuccessful() {
        Employee employee1 = new Employee("1", "Doe", "Junior developer", 35000);
        Employee employee2 = new Employee("2", "John", "Senior developer", 50000);

        Department departmentIT = new Department("IT");
        departmentIT.addEmployee(employee1);
        departmentIT.addEmployee(employee2);

        Business business = new Business("CompIT");
        business.addDepartment(departmentIT);

        HashSet<String> allPositions = business.getAllPositions();
        assertEquals(2, allPositions.size());
        assertTrue(allPositions.contains("Junior developer"));
        assertTrue(allPositions.contains("Senior developer"));
    }

    @Test
    void testGetTotalCompanySalaryIfDepartmentIsNull() {
        Department department = null;
        Business business = new Business("CompIT");
        business.addDepartment(department);
        double totalCompanySalary = business.getTotalCompanySalary();
        assertEquals(0, totalCompanySalary);
    }

    @Test
    void testGetTotalCompanySalaryWasSuccessful() {
        Employee employee = new Employee("1","Doe","Junior developer", 35000);
        Employee employee2 = new Employee("2","John","Senior developer", 50000);

        Department departmentIT = new Department("IT");
        departmentIT.addEmployee(employee);
        departmentIT.addEmployee(employee2);

        Business business = new Business("CompIT");
        business.addDepartment(departmentIT);

        double totalCompanySalary = business.getTotalCompanySalary();
        assertEquals(85000, totalCompanySalary);
    }
}
