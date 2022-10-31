package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.Employee;
import case_study.furama_resort.services.EmployeeService;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    ArrayList<Employee> employeeList = new ArrayList<>();



    public void addInformation(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public boolean deleteInformation(int employeeId, boolean choice) {
        int index = this.searchInfo(employeeId);
        if (choice) {
            return employeeList.remove(employeeList.get(index));
        }
        return false;
    }


    public Employee getEmployeeInfo(int index) {
        return employeeList.get(index);
    }

    @Override
    public int searchInfo(int employeeId) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1;
    }

//    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}

