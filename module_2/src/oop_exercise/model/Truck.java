package oop_extra_exercise.model;

import java.time.Year;

public class Truck extends Transport {
    private int load;

    public Truck() {
    }

    public Truck(int licensePlate, String carCompany, int manufacturingYear, String ownerName, int load) {
        super(licensePlate, carCompany, manufacturingYear, ownerName);
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}
