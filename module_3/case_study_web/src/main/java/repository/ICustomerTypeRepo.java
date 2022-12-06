package repository;

import model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeRepo {
    List<CustomerType> getAllCustomerType();
    String getCustomerTypeName(int id);
    int getCustomerTypeId(String name);
}
