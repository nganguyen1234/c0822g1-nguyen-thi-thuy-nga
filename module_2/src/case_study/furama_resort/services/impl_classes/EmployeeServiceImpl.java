package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.common.FileService;
import case_study.furama_resort.models.Person.Employee;
import case_study.furama_resort.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    String filePath = "src\\case_study\\furama_resort\\data\\employee.csv";
    FileService fileService = new FileService();
    List<Employee> employeeList = fileService.readEmployee(filePath);

    public void readFile() {
        employeeList = fileService.readEmployee(filePath);
    }

    public void writeFile() {
        fileService.writeEmployee(filePath, employeeList);
    }

    public void addInformation(Employee employee) {
        readFile();
        employeeList.add(employee);
        writeFile();
    }

    @Override
    public boolean deleteInformation(int employeeId, boolean choice) {
        readFile();
        int index = this.searchInfo(employeeId);
        if (choice) {
            employeeList.remove(employeeList.get(index));
            writeFile();
            return true;
        }
        return false;
    }


    public Employee getEmployeeInfo(int index) {
        readFile();
        return employeeList.get(index);
    }

    @Override
    public int searchInfo(int employeeId) {
        readFile();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        readFile();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}

