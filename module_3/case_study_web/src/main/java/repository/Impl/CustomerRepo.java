package repository.Impl;

import model.customer.Customer;
import repository.BaseRepository;
import repository.ICustomerRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<String> getAllCustomerType() {
        List<String> typeNameList = new ArrayList<>();
        try {
            PreparedStatement ps = query("select name from customer_type");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                typeNameList.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeNameList;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            PreparedStatement ps = query("insert into customer(name,customer_type_id,name,date_of_birth,gender,id_card,phone_number,email,address values(?,?,?,?,?,?,?,?);");
            ps.setInt(1, customer.getCustomerTypeId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDateOfBirth());
            ps.setInt(4, customer.getGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
