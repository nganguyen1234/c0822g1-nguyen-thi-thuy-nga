package oop_exercise.service.impl;

import oop_exercise.model.CarManufacturer;

public class CarManufacturerImpl {
    public static CarManufacturer[] carManufacturers = new CarManufacturer[5];

    static {
        carManufacturers[0] = new CarManufacturer(1, "Toyata", "Japan");
        carManufacturers[1] = new CarManufacturer(2, "Ford", "USA");
        carManufacturers[2] = new CarManufacturer(3, "Audi", "Germany");
        carManufacturers[3] = new CarManufacturer(4, "Honda", "Japan");
        carManufacturers[4] = new CarManufacturer(5, "Hyundai", "Korea");

    }

    public static void display() {
        for (CarManufacturer carManufacturer : carManufacturers) {
            System.out.println(carManufacturer.toString());
        }
    }
}
