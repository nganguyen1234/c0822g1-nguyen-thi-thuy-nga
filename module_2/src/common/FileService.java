package common;

import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.models.Person.CustomerType;
import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileService {
    public void writeFile(String filePath, List<String> strings) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : strings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCustomer(String filePath, LinkedList<Customer> customerList) {
        List<String> strings = new ArrayList<>();
        for (Customer customer : customerList) {
            strings.add(customer.convertLine());
        }
        writeFile(filePath, strings);
    }

    public List readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public LinkedList<Customer> readCustomer(String filePath) {
        LinkedList<Customer> customerList = new LinkedList<>();
        List<String> strings = readFile(filePath);
        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            customer.setName(info[0]);
            customer.setDateOfBirth(Integer.parseInt(info[1]));
            customer.setGender(info[2]);
            customer.setPhoneNumber(Integer.parseInt(info[3]));
            customer.setCitizenIdentityNumber(Integer.parseInt(info[4]));
            customer.setCustomerId(Integer.parseInt(info[5]));
            customerType.setType(info[6]);
            customer.setCustomerType(customerType);
            customer.setAddress(info[7]);
            customerList.add(customer);
        }

        return customerList;
    }
}
