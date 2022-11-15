package exercise3.controller;

import exercise3.model.Treatment;
import exercise3.service.IDoctorService;
import exercise3.service.IPatientService;
import exercise3.service.ITreatmentService;
import exercise3.service.impl.DoctorServiceImpl;
import exercise3.service.impl.PatientServiceImpl;
import exercise3.service.impl.TreatmentServiceImpl;
import exercise3.util.ExceptionHandling;
import exercise3.util.RegexCheck;

public class TreatmentController {
    private final ExceptionHandling exceptionHandling = new ExceptionHandling();
    private ITreatmentService treatmentService = new TreatmentServiceImpl();

    public void displayMenu() {
        do {
            System.out.println("1.Thêm lịch sử khám\n" +
                    "2.Thoát");
            int choice = exceptionHandling.enterPositiveNumber();
            switch (choice) {
                case 1:
                    manageData();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (true);
    }

    public void manageData() {
        RegexCheck regexCheck = new RegexCheck();
        IPatientService patientService = new PatientServiceImpl();
        IDoctorService doctorService = new DoctorServiceImpl();
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        Treatment treatment = new Treatment();
        System.out.println("Nhập số thứ tự");
        treatment.setOrder(exceptionHandling.enterPositiveNumber());
        doctorService.displayData();
        System.out.println("Nhập mã bác sĩ");
        String doctorId = regexCheck.enterDoctorId();
        treatment.setDoctorId(doctorId);
        String doctorName = doctorService.getDoctorName(doctorId);
        treatment.setDoctorName(doctorName);
        patientService.showPatientData();
        System.out.println("Nhập mã bệnh nhân");
        String patientId = regexCheck.enterPatientId();
        treatment.setPatientId(patientId);
        String patientName = patientService.getPatientName(patientId);
        treatment.setPatientName(patientName);
        if (patientService.isVip(patientId)) {
            treatment.setCost(50000);
        } else {
            treatment.setCost(100000);
        }
        treatmentService.addTreatment(treatment);
        treatmentService.writeFile();
    }
}
