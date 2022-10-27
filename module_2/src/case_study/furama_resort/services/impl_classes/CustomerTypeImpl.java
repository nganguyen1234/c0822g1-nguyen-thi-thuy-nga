package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.CustomerType;

public class CustomerTypeImpl {
    public static CustomerType[] customerTypes = new CustomerType[5];
    static {
        customerTypes[0] = new CustomerType("Diamond");
        customerTypes[1] = new CustomerType("Platinum");
        customerTypes[2] = new CustomerType("Gold");
        customerTypes[3] = new CustomerType("Silver");
        customerTypes[4] = new CustomerType("Member");
    }
    public void display(){
        for (CustomerType type:customerTypes) {
            System.out.println(type.toString());
        }
    }
}
