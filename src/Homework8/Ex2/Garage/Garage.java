package Homework8.Ex2.Garage;

import Homework8.Ex2.Cars.Car;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Map<Car, Integer> garage = new HashMap<>();
    private int numberOfCars;

    public int getNumberOfCars(Car car) {
        for (Car elements :garage.keySet()) {
            if(elements.equals(car)){
                numberOfCars+=1;
            }
        }
        return numberOfCars+1;
    }
    public void addCarOnGarage(Car car) {
        garage.put(car, getNumberOfCars(car));
    }
    public void deleteCarWithoutGarage(Car car){
        garage.put(car,getNumberOfCars(car)-1);
        garage.put(car,getNumberOfCars(car));
    }
    public void allCars() {
        for (Car element : garage.keySet()) {
            System.out.println(element + "" + garage.get(element));
        }
    }
}