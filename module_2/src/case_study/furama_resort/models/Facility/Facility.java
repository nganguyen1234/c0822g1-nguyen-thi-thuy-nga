package case_study.furama_resort.models.Facility;

public abstract class Facility {
    private String serviceName;
    private double area;
    private double cost;
    private String rent;
    private int numberOfPeople;

    public Facility() {
    }

    public Facility(String serviceName, double area, double cost, String rentalType, int numberOfPeople) {
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.rent = rentalType;
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

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
