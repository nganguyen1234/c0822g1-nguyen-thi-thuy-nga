package repository.Impl.customer;

import common.RegexCheck;
import model.customer.Customer;
import model.customer.CustomerType;
import repository.BaseRepository;
import repository.ICustomerRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepo implements ICustomerRepo {
    private final String SELECT_ALL_CUSTOMER = "select c.*, ct.name as customer_type_name\n" +
            "from customer as c\n" +
            "         left join customer_type ct on c.customer_type_id = ct.id\n" +
            "where c.is_deleted = 0;";
    private final String CREATE_NEW_CUSTOMER = "insert into customer(customer_type_id,name,date_of_birth,gender,id_card,phone_number,email,address) values(?,?,?,?,?,?,?,?);";
    private final String DELETE_CUSTOMER = "update customer set is_deleted=1 where id =?;";
    private final String EDIT_CUSTOMER = "call edit_customer(?,?,?,?,?,?,?,?,?);";
    private RegexCheck regexCheck = new RegexCheck();

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public boolean deleteCustomer(int id) {
        try {
            PreparedStatement ps = query(DELETE_CUSTOMER);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
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

    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement ps = query(SELECT_ALL_CUSTOMER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int customerTypeId = rs.getInt("customer_type_id");
                String customerTypeName = rs.getString("customer_type_name");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                int gender = rs.getInt("gender");
                String idCard = rs.getString("id_card");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                CustomerType customerType = new CustomerType(customerTypeId, customerTypeName);
                customerList.add(new Customer(id, customerType, name, dateOfBirth, gender, idCard, phoneNumber, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean addCustomer(Customer customer) throws SQLException {
            PreparedStatement ps = query(CREATE_NEW_CUSTOMER);
            ps.setInt(1, customer.getCustomerType().getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getDateOfBirth());
            ps.setInt(4, customer.getGender());
            ps.setString(5, customer.getIdCard());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setString(8, customer.getAddress());
            return ps.executeUpdate() > 0;
    }

    public boolean editCustomer(Customer customer) {
        BaseRepository bs = new BaseRepository();
        Connection connection = bs.getConnection();
        try {
            CallableStatement cs = connection.prepareCall(EDIT_CUSTOMER);
            cs.setInt(1, customer.getId());
            cs.setString(2, customer.getName());
            cs.setString(3, customer.getDateOfBirth());
            cs.setInt(4, customer.getGender());
            cs.setString(5, customer.getIdCard());
            cs.setString(6, customer.getPhoneNumber());
            cs.setString(7, customer.getEmail());
            cs.setString(8, customer.getAddress());
            cs.setInt(9, customer.getCustomerType().getId());
            return cs.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
