package repository.Impl.employee;

import model.customer.CustomerType;
import model.employee.*;
import repository.BaseRepository;
import repository.IEmployeeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private final String SELECT_ALL_EMPLOYEE = "select e.*,p.name as position_name,d.name as division_name,ed.name as education_degree\n" +
            "from employee as e\n" +
            "         left join position p on e.position_id = p.id\n" +
            "         left join division d on e.division_id = d.id\n" +
            "         left join education_degree ed on e.education_degree_id = ed.id\n" +
            "where e.is_deleted = 0;";
    private final String ADD_EMPLOYEE = "call add_employee(?,?,?,?,?,?,?,?,?,?,?,?);";

    private PreparedStatement query(String queryStatement) throws SQLException {
        BaseRepository baseRepository = new BaseRepository();
        Connection connection = baseRepository.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryStatement);
        return ps;
    }

    public List<Division> getAllDivision() {
        DivisionRepo divisionRepo = new DivisionRepo();
        return divisionRepo.getAllDivision();
    }

    public List<Position> getAllPosition() {
        PositionRepo positionRepo = new PositionRepo();
        return positionRepo.getAllPosition();
    }

    public List<EducationDegree> getAllEducationDegree() {
        EducationDegreeRepo educationDegreeRepo = new EducationDegreeRepo();
        return educationDegreeRepo.getAllEducationDegree();
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement ps = query(SELECT_ALL_EMPLOYEE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                String idCard = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int positionId = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                Position position = new Position(positionId, positionName);
                int educationDegreeId = rs.getInt("education_degree_id");
                String educationDegreeName = rs.getString("education_degree");
                EducationDegree educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);
                int divisionId = rs.getInt("division_id");
                String divisionName = rs.getString("division_name");
                Division division = new Division(divisionId, divisionName);
                User user = new User(rs.getString("username"));
                Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, position, educationDegree, division, user);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public boolean addEmployee(Employee employee) {
        try {
            PreparedStatement ps = query(ADD_EMPLOYEE);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getBirthday());
            ps.setString(3, employee.getIdCard());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getPhoneNumber());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setInt(8, employee.getPosition().getId());
            ps.setInt(9, employee.getEducationDegree().getId());
            ps.setInt(10, employee.getDivision().getId());
            ps.setString(11, employee.getUser().getUsername());
            ps.setString(12,employee.getUser().getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
