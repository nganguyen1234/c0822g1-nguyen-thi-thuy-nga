package case_study.furama_resort.models.Person;

public class CustomerType {
    private String type;

    public CustomerType() {
    }

    public CustomerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String convertLine() {
        return this.type;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "type='" + type + '\'' +
                '}';
    }
}
