package exercise3.service.impl;

import exercise3.model.Patient;
import exercise3.model.Person;
import exercise3.service.IPatientService;

import java.util.Map;
import java.util.TreeMap;

public class PatientServiceImpl implements IPatientService {
    private static Map<Integer, Patient> patientMap = new TreeMap<>();

    static {
        Patient patient1 = new Patient("BN-123", "P", "male", "11/11/2011", null);
        Patient patient2 = new Patient("BN-124", "O", "female", "11/01/2004", "11/02/2023");
        Patient patient3 = new Patient("BN-125", "I", "male", "12/11/2009", null);
        Patient patient4 = new Patient("BN-126", "U", "female", "11/06/2011", "06/02/2023");
        Patient patient5 = new Patient("BN-127", "Y", "male", "11/11/2001", "23/02/2023");
        patientMap.put(1, patient1);
        patientMap.put(2, patient2);
        patientMap.put(3, patient3);
        patientMap.put(4, patient4);
        patientMap.put(5, patient5);
    }

    public void showPatientData() {
        for (int key : patientMap.keySet()) {
            System.out.println(patientMap.get(key));
        }
    }

    public boolean checkId(String id) {
        for (int key : patientMap.keySet()) {
            if (patientMap.get(key).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String getPatientName(String id) {
        for (int key : patientMap.keySet()) {
            if (patientMap.get(key).getId().equals(id)) {
                return patientMap.get(key).getName();
            }
        }
        return null;
    }

    public boolean isVip(String id) {
        for (int key : patientMap.keySet()) {
            if (patientMap.get(key).getId().equals(id)) {
                return patientMap.get(key).getVipDate() != null;
            }
        }
        return false;
    }

}
