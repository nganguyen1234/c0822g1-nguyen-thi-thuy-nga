package oop_exercise.model;

public class Car extends Transport{
    private int numberOfSeat;
    private String type;
    public Car(){}

    public Car(int licensePlate, CarManufacturer carCompany, int manufacturingYear, String ownerName, int numberOfSeat, String type) {
        super(licensePlate, carCompany, manufacturingYear, ownerName);
        this.numberOfSeat = numberOfSeat;
        this.type = type;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeat=" + numberOfSeat +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }
}
