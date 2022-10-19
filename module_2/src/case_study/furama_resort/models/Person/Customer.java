package case_study.furama_resort.models.Person;

public class Customer extends Person {
    private int customerId;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, int dateOfBirth, String gender, int phoneNumber, int cmnd, String email, int customerId, String customerType, String address) {
        super(name, dateOfBirth, gender, phoneNumber, cmnd, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.address = address;
    }
}
