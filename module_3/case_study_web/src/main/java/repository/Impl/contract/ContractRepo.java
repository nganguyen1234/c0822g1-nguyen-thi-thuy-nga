package repository.Impl.contract;

import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Facility;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepo {
    private final String GET_ALL_CONTRACT = "select c.*,cu.name,e.name,f.name\n" +
            "from contract as c\n" +
            "left join customer cu on c.customer_id = cu.id\n" +
            "left join employee e on c.employee_id = e.id\n" +
            "left join facility f on c.facility_id = f.id\n" +
            "where c.is_deleted = 0;";

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<Contract> getAllContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement ps = query(GET_ALL_CONTRACT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                double deposit = rs.getDouble("deposit");
                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("e.name");
                Employee employee = new Employee(employeeId,employeeName);
                int customerId = rs.getInt("customer_id");
                String customerName = rs.getString("cu.name");
                Customer customer = new Customer(customerId,customerName);
                int facilityId = rs.getInt("facility_id");
                String facilityName = rs.getString("f.name");
                Facility facility = new Facility(facilityId,facilityName);
                Contract contract = new Contract(id, startDate, endDate, deposit, employee, customer, facility);
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    public Contract getContract(int id) {
        List<Contract> contractList = getAllContract();
        for (Contract contract : contractList) {
            if (contract.getId() == id) {
                return contract;
            }
        }
        return null;
    }
}
