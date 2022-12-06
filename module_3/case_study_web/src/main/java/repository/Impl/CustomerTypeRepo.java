package repository.Impl;


import model.customer.CustomerType;
import repository.BaseRepository;
import repository.ICustomerTypeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerTypeRepo implements ICustomerTypeRepo {
    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try {
            PreparedStatement ps = query("select * from customer_type");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerTypes.add(new CustomerType(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypes;
    }

    public String getCustomerTypeName(int id) {
        List<CustomerType> customerTypes = getAllCustomerType();
        for (CustomerType type : customerTypes) {
            if (type.getId() == id) {
                return type.getName();
            }
        }
        return null;
    }

    public int getCustomerTypeId(String name) {
        List<CustomerType> customerTypes = getAllCustomerType();
        for (CustomerType type : customerTypes) {
            if (type.getName().equals(name)) {
                return type.getId();
            }
        }
        return -1;
    }
}
