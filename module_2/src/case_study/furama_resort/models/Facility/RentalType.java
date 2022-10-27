package case_study.furama_resort.models.Facility;

public class RentalType {
    private String type;
    public RentalType(){
    }

    public RentalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RentalType{" +
                "type='" + type + '\'' +
                '}';
    }
}
