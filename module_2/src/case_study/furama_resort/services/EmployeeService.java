package case_study.furama_resort.services;

import case_study.furama_resort.models.Person.Employee;

public interface EmployeeService extends Service<Employee> {
    int searchInfo(int employeeId);
    boolean deleteInformation(int id,boolean choice);
}
