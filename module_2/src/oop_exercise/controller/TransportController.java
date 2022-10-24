package oop_exercise.controller;

import java.util.Scanner;

public class TransportController {
    private final TruckController truckController = new TruckController();
    private final CarController carController = new CarController();
    private final MotorbikeController motorbikeController = new MotorbikeController();

    private final Scanner scanner = new Scanner(System.in);
    private int choice2;


    public void displayMenu() {
         final TransportController transportController = new TransportController();
        int choice;
        do {
            System.out.println("------CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG------" +
                    "\nChọn chức năng:" +
                    "\n1.Thêm mới phương tiện" +
                    "\n2.Hiển thị phương tiện" +
                    "\n3.Xóa phương tiện" +
                    "\n4.Tìm kiếm theo biển kiểm soát" +
                    "\n5.Thoát" +
                    "\nNhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 5 || choice < 1) {
                System.out.println("!!!!!Vui lòng nhập đúng lựa chọn hệ thống cung cấp");
            }
            switch (choice) {
                case 1:
                    transportController.add();
                    break;
                case 2:
                    transportController.display();
                    break;
                case 3:
                    transportController.remove();
                    break;
                case 4:
                    transportController.find();
                    break;
                case 5:
                    System.exit(5);
            }
        } while (true);
    }

    private void add() {
        do {
            System.out.println("**Chức năng 1**\n" +
                    "1.\tThêm xe tải\n" +
                    "2.\tThêm ôtô\n" +
                    "3.\tThêm  xe máy\n" +
                    "4.\tVề lại menu chính");
            System.out.println("Nhập lựa chọn tiếp theo của bạn:");
            choice2 = Integer.parseInt(scanner.nextLine());
            if (choice2 > 4 || choice2 < 1) {
                System.out.println("!!!!!Vui lòng nhập đúng lựa chọn hệ thống cung cấop");
            }
            switch (choice2) {
                case 1:
                    this.truckController.add();
                    break;
                case 2:
                    carController.add();
                    break;
                case 3:
                    motorbikeController.add();
                    break;
                case 4:
                    break;
            }
        } while (choice2 != 4);
    }

    private void display() {
        do {
            System.out.println("**Chức năng 2**\n" +
                    "1.\tHiện thị xe tải\n" +
                    "2.\tHiện thị ôtô.\n" +
                    "3.\tHiện  xe máy.\n" +
                    "4.\tVề lại menu chính");
            System.out.println("Nhập lựa chọn tiếp theo của bạn:");
            choice2 = Integer.parseInt(scanner.nextLine());
            if (choice2 > 4 || choice2 < 1) {
                System.out.println("!!!!!Vui lòng nhập đúng lựa chọn hệ thống cung cấp");
            }
            switch (choice2) {
                case 1:
                    truckController.display();
                    break;
                case 2:
                    carController.display();
                    break;
                case 3:
                    motorbikeController.display();
                    break;
                case 4:
                    break;
            }
        } while (choice2 != 4);
    }

    private void remove() {
        System.out.println("**Chức năng 3**\n" +
                "Xóa thông tin phương tiện" +
                "\nNhập biển kiểm soát của phương tiện muốn xóa");
        int licensePlate = Integer.parseInt(scanner.nextLine());
        truckController.remove(licensePlate);
        carController.remove(licensePlate);
        motorbikeController.remove(licensePlate);

    }

    private void find() {
        System.out.println("**Chức năng 4**\n" +
                "Tìm kiếm thông tin" +
                "\nNhập vào biển kiểm soát phương tiện muốn tìm");
        int licensePlate = Integer.parseInt(scanner.nextLine());
        truckController.find(licensePlate);
        carController.find(licensePlate);
        motorbikeController.find(licensePlate);
    }


}
