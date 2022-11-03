package case_study.furama_resort.models.Facility;

import java.util.Objects;

public class Room extends Facility {
    private String complimentaryService;

    public Room() {
        super();
    }

    public Room(String serviceId, String serviceName, double area, double cost, RentalType rent, int numberOfPeople, String complimentaryService) {
        super(serviceId, serviceName, area, cost, rent, numberOfPeople);
        this.complimentaryService = complimentaryService;
    }

    public String getComplimentaryService() {
        return complimentaryService;
    }

    public void setComplimentaryService(String complimentaryService) {
        this.complimentaryService = complimentaryService;
    }

    public String convertLine() {
        String comma = ",";
        return super.convertLine() + comma + this.complimentaryService;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString() +
                ", complimentary service='" + complimentaryService + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(getServiceName(), room.getServiceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceName());
    }
}
