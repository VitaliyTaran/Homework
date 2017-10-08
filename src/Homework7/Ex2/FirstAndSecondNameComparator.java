package Homework7.Ex2;

import java.util.Comparator;

public class FirstAndSecondNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        String firstStudentFulName = firstStudent.getFirstName() +" "+ firstStudent.getLastName();
        String secondStudentFulName = secondStudent.getFirstName() +" "+ secondStudent.getLastName();
        return firstStudentFulName.compareTo(secondStudentFulName);
    }
}
