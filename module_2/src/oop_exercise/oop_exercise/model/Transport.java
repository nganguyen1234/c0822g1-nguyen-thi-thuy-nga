package oop_exercise.model;

public abstract class Transport {
    private int licensePlate;
    private CarManufacturer carManufacturer;
    private int manufacturingYear;
    private String ownerName;

    public Transport(int licensePlate, CarManufacturer carCompany, int manufacturingYear, String ownerName) {
        this.licensePlate = licensePlate;
        this.carManufacturer = carCompany;
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

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
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

    @Override
    public String toString() {
        return "Transport{" +
                "licensePlate=" + licensePlate +
                ", carCompany='" + carManufacturer + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

