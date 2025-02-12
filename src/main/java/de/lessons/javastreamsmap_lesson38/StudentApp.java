package de.lessons.javastreamsmap_lesson38;

import com.github.javafaker.Faker;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentApp {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<Student> students = List.of(
                new Student(faker.name().lastName(), 18, "IT", 3.8),
                new Student(faker.name().lastName(), 20, "Bio", 3.0),
                new Student(faker.name().lastName(), 21, "Math", 3.5),
                new Student(faker.name().lastName(), 22, "Physics", 3.2),
                new Student(faker.name().lastName(), 23, "Chemistry", 1.7),
                new Student(faker.name().lastName(), 24, "Geography", 2.4)
        );
        /*
        1. Отфильтровать всех студентов, чей средний балл (gpa) больше либо равен 3.0.
        2. Собрать их в список и вывести на экран.
         */
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getGpa() >= 3.0)
                .collect(Collectors.toList());
        System.out.println("Students with GPA >= 3.0: " + filteredStudents);

        /*
        1. Найти самого старшего студента в списке (по age).
        2. Результат вывести в консоль.
         */
        Optional<Student> oldStudent = students.stream()
                .max(Comparator.comparingInt(Student::getAge));
        System.out.println("Oldest student: " + oldStudent.get());

        /*
        1. Проверить, есть ли хотя бы один студент, у которого средний балл (gpa) меньше 3.0.
        2. Вывести в консоль true/false по результату.
         */
        boolean resultLowGpa = students.stream()
                .anyMatch(student -> student.getGpa() < 3.0);
        System.out.println("Is there any student with GPA < 3.0? " + resultLowGpa);
    }
}
