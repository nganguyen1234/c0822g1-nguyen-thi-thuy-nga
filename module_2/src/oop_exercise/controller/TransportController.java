package oop_exercise.controller;

import oop_exercise.model.Truck;
import oop_exercise.service.impl.CarServiceImpl;
import oop_exercise.service.impl.MotorBikeServiceImpl;
import oop_exercise.service.impl.TruckServiceImpl;

import java.util.Scanner;

public class TransportController {
    public void displayMenu() {
        int choice;
        int choice2;
        TruckServiceImpl truckService = new TruckServiceImpl();
        MotorBikeServiceImpl motorBikeService = new MotorBikeServiceImpl();
        CarServiceImpl carService = new CarServiceImpl();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG" +
                    "\nChọn chức năng:" +
                    "\n1.Thêm mới phương tiện" +
                    "\n2.Hiển thị phương tiện" +
                    "\n3.Xóa phương tiện" +
                    "\n4.Tìm kiếm theo biển kiểm soát" +
                    "\n5.Thoát" +
                    "\nNhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    do {
                        System.out.println("1. Thêm xe tải,\n" +
                                " \t2. Thêm ôtô, \n" +
                                "3. Thêm  xe máy\n" +
                                "4. Về lại menu chính");
                        System.out.println("Nhập lựa chọn tiếp theo của bạn:");
                        choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
                            case 1:
                                truckService.add();
                                break;
                            case 2:
                                motorBikeService.add();
                                break;
                            case 3:
                                carService.add();
                                break;
                            case 4:
                                break;
                        }
                    } while (choice2 != 4);
//                case 2:
//                case 3:
//                case 4:
                case 5:
                    System.exit(5);
            }
        } while (true);
    }
}
