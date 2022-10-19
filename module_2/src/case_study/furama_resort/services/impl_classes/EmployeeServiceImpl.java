package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.Employee;
import case_study.furama_resort.services.EmployeeService;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeServiceImpl implements EmployeeService {
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addInfor() {
        Employee employee1 = new Employee();
        System.out.println("Enter employee's name");
        employee1.setName(scanner.nextLine());
        System.out.println("Enter employee's date of birth:");
        employee1.setDateOfBirth(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter employee's gender");
        employee1.setGender(scanner.nextLine());
        System.out.println("Enter employee's phone number");
        employee1.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter employee's cmnd");
        employee1.setCmnd(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter employee's id");
        employee1.setEmployeeId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter employee's salary:");
        employee1.setSalary(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter employee's ");
        employeeList.add(employee1);
    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }
}

