package de.homeworks.homework27;

import java.util.Objects;

public class Employee {
    private String id;
    private String name;
    private String position;
    private double salary;

    public Employee(double salary, String position, String name, String id) {
        this.salary = salary;
        this.position = position;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    protected String getInfo() {
        return "Employee{" +
                "id='" + id + ", name='" + name + ", position='" + position + ", salary=" + salary + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
