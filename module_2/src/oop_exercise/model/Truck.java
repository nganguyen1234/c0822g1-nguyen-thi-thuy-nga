package oop_exercise.model;

public class Truck extends Transport {
    private int load;

    public Truck() {
    }

    public Truck(int licensePlate, CarManufacturer carCompany, int manufacturingYear, String ownerName, int load) {
        super(licensePlate, carCompany, manufacturingYear, ownerName);
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Truck{} " + super.toString();
    }
}
