package Homework8.Ex2.Cars;


public class HatchBack extends Car {

    public HatchBack(String markOfCar, String modelOfCar, int yearOfIssue, int hoursePower, double acceletetionTo100, TypeOfFuel typeOfFuel) {
        super(markOfCar, modelOfCar, yearOfIssue, hoursePower, acceletetionTo100, typeOfFuel);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Car car) {
        return super.equals(car);
    }
    @Override
    public String toString() {
        return super.toString() + "; тип кузова: хэтчбек";
    }
}
