package Homework8.Ex2.Cars;

public abstract class Car {
    private String markOfCar;
    private String modelOfCar;
    private int yearOfIssue;
    private int hoursePower;
    private double acceletetionTo100;
    private TypeOfFuel typeOfFuel;

    public Car() {
    }
    public Car(String markOfCar, String modelOfCar, int yearOfIssue, int hoursePower, double acceletetionTo100, TypeOfFuel typeOfFuel) {
        this.markOfCar = markOfCar;
        this.modelOfCar = modelOfCar;
        this.yearOfIssue = yearOfIssue;
        this.hoursePower = hoursePower;
        this.acceletetionTo100 = acceletetionTo100;
        this.typeOfFuel = typeOfFuel;
    }
    @Override
    public int hashCode() {
        int result = 18;
        result = 31 * result + markOfCar.hashCode();
        result = 31 * result + modelOfCar.hashCode();
        result = 31 * result + yearOfIssue;
        result = 31 * result + hoursePower;
        result = 31 * result + (int) acceletetionTo100;
        result = 31 * result + typeOfFuel.hashCode();
        return result;
    }
    public boolean equals(Car car) {
        if (this.markOfCar.equals(car.markOfCar)
                && this.modelOfCar.equals(car.modelOfCar)
                && this.yearOfIssue == car.yearOfIssue
                && this.hoursePower == car.hoursePower
                && this.acceletetionTo100 == car.acceletetionTo100
                && this.typeOfFuel.equals(car.typeOfFuel)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "Марка:" + markOfCar
                + "; модель: " + modelOfCar
                + "; год выпуска: " + yearOfIssue
                + "; лощадиные силы: " + hoursePower
                + "; разгон до сотни - " + acceletetionTo100
                + "; тип топлива " + typeOfFuel;
    }
    public String shortDiscription(){
        return "Марка:" + markOfCar
                + "; модель: " + modelOfCar;
    }
}