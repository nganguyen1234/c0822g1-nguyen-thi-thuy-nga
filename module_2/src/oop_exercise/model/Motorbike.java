package oop_exercise.model;

public class Motorbike extends Transport {
    private int capacity;

    public Motorbike() {}

    public Motorbike(int licensePlate, CarManufacturer carCompany, int manufacturingYear, String ownerName, int capacity) {
        super(licensePlate, carCompany, manufacturingYear, ownerName);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
