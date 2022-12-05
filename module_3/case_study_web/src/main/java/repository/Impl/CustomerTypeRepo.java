package repository.Impl;


import model.customer.CustomerType;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerTypeRepo {
    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<CustomerTypeRepo> getAllCustomerType() {
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
        return customerType;
    }

    public List<String> getCustomerTypeName(){
        Map<Integer, String> customerType = getAllCustomerType();
        return customerType.entrySet();
    }

    public int getCustomerTypeId(String name) {
        Map<Integer, String> customerType = getAllCustomerType();
        Set<Integer> idList = customerType.keySet();
        for (Integer id : idList) {
            if (customerType.get(id).equals(name)) {
                return id;
            }
        }
        return -1;
    }
}
