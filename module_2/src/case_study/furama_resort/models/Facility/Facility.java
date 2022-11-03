package case_study.furama_resort.models.Facility;

import java.util.Objects;

public abstract class Facility {
    protected String serviceId;
    protected String serviceName;
    protected double area;
    protected double cost;
    protected RentalType rent;
    protected int numberOfPeople;

    public Facility() {
    }

    protected Facility(String serviceName) {
        this.serviceName = serviceName;
    }

    protected Facility(String serviceId, String serviceName, double area, double cost, RentalType rent, int numberOfPeople) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.rent = rent;
        this.numberOfPeople = numberOfPeople;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public RentalType getRent() {
        return rent;
    }

    public void setRent(RentalType rent) {
        this.rent = rent;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String convertLine() {
        String comma = ",";
        return this.serviceId + comma + this.serviceName + comma + this.area + comma + this.cost + comma + this.rent.convertLine() + comma + this.numberOfPeople;
    }

    @Override
    public String toString() {
        return "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", rent=" + rent +
                ", numberOfPeople=" + numberOfPeople;
    }
}
