import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Himanshu", 85),
                new Student("Rahul", 70),
                new Student("Priya", 92),
                new Student("Aman", 76)
        );

        System.out.println("Students scoring above 75% sorted by marks:");

        students.stream()
                .filter(s -> s.marks > 75)                 
                .sorted((s1, s2) -> s1.marks - s2.marks)   
                .map(s -> s.name)                          
                .forEach(System.out::println);            
    }
}
