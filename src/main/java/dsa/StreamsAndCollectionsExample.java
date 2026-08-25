package main.java.dsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates common Java Streams and Collections operations.
 *
 * <p>The example covers filtering, mapping, sorting, grouping,
 * counting, and collecting stream results.
 *
 * <p>This example is useful for Java backend interview preparation.
 */
public class StreamsAndCollectionsExample {

    record Employee(
            int id,
            String name,
            String department,
            int salary
    ) {
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(101, "Abhishek", "Engineering", 120000),
                new Employee(102, "Rahul", "Engineering", 100000),
                new Employee(103, "Amit", "Finance", 90000),
                new Employee(104, "Priya", "Engineering", 110000),
                new Employee(105, "Neha", "Finance", 95000)
        ));

        System.out.println("Employees earning above 100000:");

        employees.stream()
                .filter(employee -> employee.salary() > 100000)
                .forEach(System.out::println);

        List<String> names = employees.stream()
                .map(Employee::name)
                .sorted()
                .toList();

        System.out.println("\nSorted names:");
        System.out.println(names);

        Map<String, List<Employee>> byDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department
                        ));

        System.out.println("\nEmployees by department:");
        byDepartment.forEach(
                (department, list) ->
                        System.out.println(department + " -> " + list)
        );

        Map<String, Long> employeeCountByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::department,
                                Collectors.counting()
                        ));

        System.out.println("\nEmployee count by department:");
        System.out.println(employeeCountByDepartment);

        Employee highestPaid = employees.stream()
                .max(Comparator.comparingInt(Employee::salary))
                .orElseThrow();

        System.out.println("\nHighest paid employee:");
        System.out.println(highestPaid);

        Map<String, Integer> salaryByEmployee =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::name,
                                Employee::salary
                        ));

        System.out.println("\nSalary by employee:");
        System.out.println(salaryByEmployee);
    }
}