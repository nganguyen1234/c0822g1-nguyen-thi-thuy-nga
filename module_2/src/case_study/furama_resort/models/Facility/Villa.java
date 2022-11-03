package case_study.furama_resort.models.Facility;

import java.util.Objects;

public class Villa extends Facility {
    private double poolArea;
    private String typeOfRoom;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String serviceId, String serviceName, double area, double cost, RentalType rentalType, int numberOfPeople, double poolArea, String typeOfRoom, int numberOfFloors) {
        super(serviceId, serviceName, area, cost, rentalType, numberOfPeople);
        this.poolArea = poolArea;
        this.typeOfRoom = typeOfRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String convertLine() {
        String comma = ",";
        return super.convertLine() + comma + this.poolArea + comma + this.typeOfRoom + comma + this.numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                ", poolArea:" + poolArea + '\'' +
                ", typeOfRoom:'" + typeOfRoom + '\'' +
                ", numberOfFloors:" + numberOfFloors +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Villa)) return false;
        Villa villa = (Villa) o;
        return Objects.equals(getServiceName(), villa.getServiceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceName());
    }
}
