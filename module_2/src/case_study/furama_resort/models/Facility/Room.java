package case_study.furama_resort.models.Facility;

public class Room extends Facility {
    private String complimentaryService;

    public Room() {
    }

    public Room(String serviceName, double area, double cost, String rentalType, int numberOfPeople, String complimentaryService) {
        super(serviceName, area, cost, rentalType, numberOfPeople);
        this.complimentaryService = complimentaryService;
    }

    public String getComplimentaryService() {
        return complimentaryService;
    }

    public void setComplimentaryService(String complimentaryService) {
        this.complimentaryService = complimentaryService;
    }
}
