package Homework7.Ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfStudnets {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Петр", "Иванов", 10, 9));
        students.add(new Student("Гриша", "Романов", 11, 10));
        students.add(new Student("Иван", "Пилуй", 12, 9));
        students.add(new Student("Александр", "Соколов", 13, 8));
        Student studentWithMaxAvarageScore = students.get(0);
        for (Student student : students) {
            if (studentWithMaxAvarageScore.getAvarageScore() < student.getAvarageScore()) {
                studentWithMaxAvarageScore = student;
            }
        }
        System.out.println("Наибольший балл " + studentWithMaxAvarageScore);
        System.out.println("\n Сортировка по полоному имени:");
        Collections.sort(students, new FirstAndSecondNameComparator());
        students.forEach(System.out::println);
        System.out.println("\n Сортировка по возросту:");
        Collections.sort(students, new AgeComparator());
        students.forEach(System.out::println);
        System.out.println("\n Сортировка по среднему баллу:");
        Collections.sort(students, new AvarageScoreComparator());
        students.forEach(System.out::println);
    }
}
