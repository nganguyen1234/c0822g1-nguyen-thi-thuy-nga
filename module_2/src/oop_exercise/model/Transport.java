package oop_extra_exercise.model;

import java.time.Year;

public abstract class Transport {
    private int licensePlate;
    private String carCompany;
    private int manufacturingYear;
    private String ownerName;

    public Transport(int licensePlate, String carCompany, int manufacturingYear, String ownerName) {
        this.licensePlate = licensePlate;
        this.carCompany = carCompany;
        this.manufacturingYear = manufacturingYear;
        this.ownerName = ownerName;
    }
    public Transport(){}

    public int getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(int licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}

