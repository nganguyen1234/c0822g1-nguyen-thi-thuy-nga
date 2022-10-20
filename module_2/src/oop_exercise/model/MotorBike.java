package oop_extra_exercise.model;

import java.time.Year;

public class MotorBike extends Transport {
    private int capacity;

    public MotorBike() {}

    public MotorBike(int licensePlate, String carCompany, int manufacturingYear, String ownerName, int capacity) {
        super(licensePlate, carCompany, manufacturingYear, ownerName);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
