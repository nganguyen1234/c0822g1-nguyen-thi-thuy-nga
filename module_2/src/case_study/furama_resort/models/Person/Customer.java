package case_study.furama_resort.models.Person;

import java.util.Objects;

public class Customer extends Person {
    private int customerId;
    private CustomerType customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String gender, int phoneNumber, int citizenIdentityNumber, String email, int customerId, CustomerType customerType, String address) {
        super(name, dateOfBirth, gender, phoneNumber, citizenIdentityNumber, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String convertLine() {
        String comma = ",";
        return super.convertLine() + comma + this.customerId + comma + this.customerType.convertLine() + comma + this.address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                ", customerId=" + customerId +
                ", customerType=" + customerType +
                ", address='" + address + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId();
    }

    @Override
    public int hashCode() {
        return 1 + Objects.hash(getCustomerId());
    }
}
