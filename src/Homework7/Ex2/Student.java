package Homework7.Ex2;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double avarageScore;

    @Override
    public String toString() {
        return "Студент " + firstName + ", " + lastName + ", возрост " + age + ", Средний балл " + avarageScore;
    }
    public Student(String firstName, String lastName, int age, double avarageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.avarageScore = avarageScore;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getAvarageScore() {
        return avarageScore;
    }
    public void setAvarageScore(double avarageScore) {
        this.avarageScore = avarageScore;
    }
}
