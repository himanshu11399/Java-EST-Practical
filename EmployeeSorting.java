import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Himanshu", 23, 50000),
                new Employee("Amit", 25, 65000),
                new Employee("Riya", 22, 45000)
        );

       
        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));

        System.out.println("Employees Sorted by Salary:");
        employees.forEach(System.out::println);
    }
}
