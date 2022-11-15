package exercise3.service.impl;

import exercise3.model.Doctor;
import exercise3.model.Person;
import exercise3.service.IDoctorService;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class DoctorServiceImpl implements IDoctorService {
    private static Map<Integer, Person> doctorMap = new TreeMap<>();

    static {
        Person doctor1 = new Doctor("BS-123", "A", "male", 5);
        Person doctor2 = new Doctor("BS-123", "B", "female", 5);
        Person doctor3 = new Doctor("BS-125", "C", "male", 2);
        Person doctor4 = new Doctor("BS-126", "D", "female", 1);
        Person doctor5 = new Doctor("BS-127", "E", "female", 10);
        doctorMap.put(1, doctor1);
        doctorMap.put(2, doctor2);
        doctorMap.put(3, doctor3);
        doctorMap.put(4, doctor4);
        doctorMap.put(5, doctor5);
    }

    public void displayData() {
        for (int key : doctorMap.keySet()) {
            System.out.println(doctorMap.get(key));
        }
    }

    public boolean checkId(String id) {
        for (int key : doctorMap.keySet()) {
            if (doctorMap.get(key).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String getDoctorName(String id) {
        for (int key : doctorMap.keySet()) {
            if (doctorMap.get(key).getId().equals(id)) {
                return doctorMap.get(key).getName();
            }
        }
        return null;
    }

}
