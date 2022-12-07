package service.Impl;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.IEmployeeRepo;
import repository.Impl.employee.EmployeeRepo;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepo employeeRepo = new EmployeeRepo();

    @Override
    public List<Division> getAllDivision() {
        return employeeRepo.getAllDivision();
    }

    @Override
    public List<Position> getAllPosition() {
        return employeeRepo.getAllPosition();
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return employeeRepo.getAllEducationDegree();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.getAllEmployee();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeRepo.addEmployee(employee);
    }
}
