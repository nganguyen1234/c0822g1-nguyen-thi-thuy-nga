package exercise3.util;

import exercise3.service.IDoctorService;
import exercise3.service.IPatientService;
import exercise3.service.impl.DoctorServiceImpl;
import exercise3.service.impl.PatientServiceImpl;

import java.util.Scanner;

public class RegexCheck {
    Scanner scanner = new Scanner(System.in);

    public String enterDate() {
        do {
            String date = scanner.nextLine();
            if (date.matches("dd/MM/yyyy")) {
                return date;
            }
            System.out.println("Vui lòng nhập lại đúng định dạng dd/MM/yyyy");
        } while (true);
    }

    public String enterDoctorId() {
        IDoctorService doctorService = new DoctorServiceImpl();
        do {
            String doctorId = scanner.nextLine();
            if (doctorId.matches("BS-\\d{3}")) {
                if (doctorService.checkId(doctorId)) {
                    return doctorId;
                } else {
                    System.out.println("Không tồn tại mã bác sĩ này");
                }
            }
            System.out.println("vui lòng nhập lại");
            ;

        } while (true);
    }

    public String enterPatientId() {
        IPatientService patientService = new PatientServiceImpl();
        do {
            String patientId = scanner.nextLine();
            if (patientId.matches("BN-\\d{3}")) {
                if (patientService.checkId(patientId)) {
                    return patientId;
                } else {
                    System.out.println("Không tồn tại mã bệnh nhân này");
                }
            }
            System.out.println("vui lòng nhập lại");
            ;

        } while (true);
    }
}

