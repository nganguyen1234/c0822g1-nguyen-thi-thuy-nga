package case_study.furama_resort.common;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Facility.RentalType;
import case_study.furama_resort.models.Facility.Room;
import case_study.furama_resort.models.Facility.Villa;
import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.models.Person.CustomerType;
import case_study.furama_resort.models.Person.EducationLevel;
import case_study.furama_resort.models.Person.Employee;
import case_study.furama_resort.services.BookingComparator;
import case_study.furama_resort.services.BookingService;
import case_study.furama_resort.services.impl_classes.BookingServiceImpl;


import java.io.*;
import java.util.*;

public class FileService {

    public void writeFile(String filePath, List<String> strings) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : strings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeEmployee(String filePath, List<Employee> employeeList) {
        List<String> strings = new ArrayList<>();
        for (Employee employee : employeeList) {
            strings.add(employee.convertLine());
        }
        writeFile(filePath, strings);
    }

    public void writeBooking(String filePath, TreeSet<Booking> bookingSet) {
        List<String> strings = new ArrayList<>();
        for (Booking booking : bookingSet) {
            strings.add(booking.convertLine());
        }
        writeFile(filePath, strings);
    }

    public void writeCustomer(String filePath, LinkedList<Customer> customerList) {
        List<String> strings = new ArrayList<>();
        for (Customer customer : customerList) {
            strings.add(customer.convertLine());
        }
        writeFile(filePath, strings);
    }

    public void writeVilla(String filePath, LinkedHashMap<Villa, Integer> villaMap) {
        List<String> strings = new ArrayList<>();
        Set<Villa> villaSet = villaMap.keySet();
        villaSet.forEach(villa -> strings.add(villa.convertLine()));
        writeFile(filePath, strings);
    }

    public void writeRoom(String filePath, LinkedHashMap<Room, Integer> roomMap) {
        List<String> strings = new ArrayList<>();
        Set<Room> roomSet = roomMap.keySet();
        roomSet.forEach(room -> strings.add(room.convertLine()));
        writeFile(filePath, strings);
    }

    public List<String> readFile(String filePath) {
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

    public List<Employee> readEmployee(String filePath) {
        List<Employee> employeeList = new LinkedList<>();
        File file = new File(filePath);
        if (file.exists()) {
            List<String> strings = readFile(filePath);
            for (String line : strings) {
                Employee employee = new Employee();
                String[] info = line.split(",");
                employee.setName(info[0]);
                employee.setDateOfBirth(info[1]);
                employee.setGender(info[2]);
                employee.setPhoneNumber(Integer.parseInt(info[3]));
                employee.setCitizenIdentityNumber(Integer.parseInt(info[4]));
                employee.setEmail(info[5]);
                employee.setEmployeeId(Integer.parseInt(info[6]));
                employee.setPosition(info[7]);
                employee.setSalary(Double.parseDouble(info[8]));
                employee.setEducationLevel(new EducationLevel(info[9]));
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public TreeSet<Booking> readBooking(String filePath) {
        TreeSet<Booking> bookingList = new TreeSet<>(new BookingComparator());
        File file = new File(filePath);
        if (file.exists()) {
            List<String> strings = readFile(filePath);
            for (String line : strings) {
                Booking booking = new Booking();
                String[] info = line.split(",");
                booking.setBookingId(Integer.parseInt(info[0]));
                booking.setStartDate(info[1]);
                booking.setEndDate(info[2]);
                booking.setServiceName(info[3]);
                booking.setCustomerId(Integer.parseInt(info[4]));
                bookingList.add(booking);
            }
        }
        return bookingList;
    }

    public LinkedList<Customer> readCustomer(String filePath) {
        LinkedList<Customer> customerList = new LinkedList<>();
        File file = new File(filePath);
        if (file.exists()) {
            List<String> strings = readFile(filePath);

            for (String line : strings) {
                Customer customer = new Customer();
                CustomerType customerType = new CustomerType();
                String[] info = line.split(",");
                customer.setName(info[0]); // read customer
                customer.setDateOfBirth(info[1]);
                customer.setGender(info[2]);
                customer.setPhoneNumber(Integer.parseInt(info[3]));
                customer.setCitizenIdentityNumber(Integer.parseInt(info[4]));
                customer.setEmail(info[5]);
                customer.setCustomerId(Integer.parseInt(info[6]));
                customerType.setType(info[7]); // read customerType
                customer.setCustomerType(customerType);
                customer.setAddress(info[8]);
                customerList.add(customer);
            }
        }
        return customerList;
    }

    public LinkedHashMap<Facility, Integer> readFacility(String villaFilePath, String roomFilePath) {
        LinkedHashMap<Facility, Integer> facilityMap = new LinkedHashMap<>();
        LinkedHashMap<Villa, Integer> villaMap = readVillaMap(villaFilePath);
        Set<Villa> villaSet = villaMap.keySet();
        villaSet.forEach(key -> {
            facilityMap.put(key, villaMap.get(key));
        });
        LinkedHashMap<Room, Integer> roomMap = readRoomMap(roomFilePath);
        Set<Room> roomSet = roomMap.keySet();
        roomSet.forEach(key -> {
            facilityMap.put(key, roomMap.get(key));
        });
        return facilityMap;
    }


    public LinkedHashMap<Villa, Integer> readVillaMap(String filePath) {
        BookingService bookingService = new BookingServiceImpl();
        LinkedHashMap<Villa, Integer> villaMap = new LinkedHashMap<>();
        File file = new File(filePath);
        if (file.exists()) {
            List<String> strings = readFile(filePath);
            int value;
            for (String line : strings) {
                String[] info = line.split(",");
                Villa villa = new Villa();
                RentalType rent = new RentalType();
                villa.setServiceId(info[0]);
                villa.setServiceName(info[1]);
                villa.setArea(Double.parseDouble(info[2]));
                villa.setCost(Double.parseDouble(info[3]));
                rent.setType(info[4]);
                villa.setRent(rent);
                villa.setNumberOfPeople(Integer.parseInt(info[5]));
                villa.setPoolArea(Double.parseDouble(info[6]));
                villa.setRoomStandard(info[7]);
                villa.setNumberOfFloors(Integer.parseInt(info[8]));
                value = bookingService.countFacility(info[1]);
                villaMap.put(villa, value);
            }
        }
        return villaMap;
    }

    public LinkedHashMap<Room, Integer> readRoomMap(String filePath) {
        BookingService bookingService = new BookingServiceImpl();
        LinkedHashMap<Room, Integer> roomMap = new LinkedHashMap<>();
        File file = new File(filePath);
        if (file.exists()) {
            List<String> strings = readFile(filePath);
            int value;
            for (String line : strings) {
                String[] info = line.split(",");
                Room room = new Room();
                RentalType rent = new RentalType();
                room.setServiceId(info[0]);
                room.setServiceName(info[1]);
                room.setArea(Double.parseDouble(info[2]));
                room.setCost(Double.parseDouble(info[3]));
                rent.setType(info[4]);
                room.setRent(rent);
                room.setNumberOfPeople(Integer.parseInt(info[5]));
                room.setComplimentaryService(info[6]);
                value = bookingService.countFacility(info[1]);
                roomMap.put(room, value);
            }
        }
        return roomMap;
    }

}
