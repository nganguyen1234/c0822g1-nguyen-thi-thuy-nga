package case_study.furama_resort.models.Facility;

public class Villa extends Facility {
    private double poolArea;
    private String typeOfRoom;

    public Villa() {
    }

    public Villa(String serviceName, double area, double cost, String rentalType, int numberOfPeople, double poolArea, String typeOfRoom) {
        super(serviceName, area, cost, rentalType, numberOfPeople);
        this.poolArea = poolArea;
        this.typeOfRoom = typeOfRoom;
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
}
