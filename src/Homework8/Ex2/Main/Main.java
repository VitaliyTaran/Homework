package Homework8.Ex2.Main;

import Homework8.Ex2.Cars.HatchBack;
import Homework8.Ex2.Cars.Minivan;
import Homework8.Ex2.Cars.Sedan;
import Homework8.Ex2.Garage.Garage;

import static Homework8.Ex2.Cars.TypeOfFuel.*;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Sedan sedan = new Sedan("BMW", "I320", 1999, 150, 3.2, DIESEL);
        Minivan minivan = new Minivan("Mers", "G12", 2002, 201, 5.6, DIESEL);
        HatchBack hatchBack = new HatchBack("WoltsWagen", "s31",2005,102,4.3,GAS);
        garage.addCarOnGarage(minivan);
        garage.addCarOnGarage(hatchBack);
        garage.addCarOnGarage(hatchBack);
        garage.addCarOnGarage(sedan);
        garage.deleteCarWithoutGarage(sedan);
        garage.deleteCarWithoutGarage(sedan);

        garage.allCars();
    }
}
