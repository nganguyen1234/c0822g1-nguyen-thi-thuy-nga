package com.example.service.employee;

import com.example.model.customer.Customer;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.util.exception.DataDuplicationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Page<Employee> getEmployeePage(String name, String email, Pageable pageable);
    List<Position> getPositionList();
    List<Division> getDivisionList();
    List<EducationDegree> getEducationDegreeList();
    Employee addEmployee(Employee employee) throws DataDuplicationException;
}
