package Homework7.Ex2;

import java.util.Comparator;

public class AvarageScoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return new Double(firstStudent.getAvarageScore()).compareTo(secondStudent.getAvarageScore());
    }
}
