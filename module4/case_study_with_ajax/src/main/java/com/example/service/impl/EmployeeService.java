package com.example.service.impl;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.repository.employee.IDivisionRepository;
import com.example.repository.employee.IEducationDegreeRepository;
import com.example.repository.employee.IEmployeeRepository;
import com.example.repository.employee.IPositionRepository;
import com.example.service.employee.IEmployeeService;
import com.example.util.exception.DataDuplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;
    @Autowired
    IDivisionRepository divisionRepository;
    @Autowired
    IPositionRepository positionRepository;
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployeePage(String name, String email, Pageable pageable) {
        return employeeRepository.getEmployeePage(name, email, pageable);
    }

    @Override
    public List<Position> getPositionList() {
        return positionRepository.findAll();
    }

    @Override
    public List<Division> getDivisionList() {
        return divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> getEducationDegreeList() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) throws DataDuplicationException {
        boolean idCardCheck = checkIdCard(employee.getIdCard());
        boolean emailCheck = checkEmail(employee.getEmail());
        boolean phoneNumberCheck = checkPhoneNumber(employee.getPhoneNumber());
        DataDuplicationException dataDuplicationException = new DataDuplicationException();
        if (idCardCheck) {
            dataDuplicationException.getErrorMap().put("idCard", "CMND bạn nhập đã tồn tại");
        }
        if (emailCheck) {
            dataDuplicationException.getErrorMap().put("email", "email bạn nhập đã tồn tại");
        }
        if (phoneNumberCheck) {
            dataDuplicationException.getErrorMap().put("phoneNumber", "số điện thoại bạn nhập đã tồn tại");
        }
        if (!dataDuplicationException.getErrorMap().isEmpty()) {
            throw dataDuplicationException;
        }
        if (isExist(employee)) {
            return null;
        }
        try {
            return employeeRepository.save(employee);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return null;
        }
    }

    public boolean isExist(Employee employee) {
        Employee employee1 = employeeRepository.findById(employee.getId()).orElse(null);
        return employee1 != null;
    }

    private boolean checkIdCard(String idCard) {
        return employeeRepository.findByIdCard(idCard) != null;
    }

    private boolean checkEmail(String email) {
        return employeeRepository.findByEmail(email) != null;
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber) != null;
    }
}
