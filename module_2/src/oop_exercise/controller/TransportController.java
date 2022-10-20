package oop_extra_exercise.controller;

import java.util.Scanner;

public class TransportController {
    public void displayMenu() {
        int choice;
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
//                case 1:
//                    do {
//                        System.out.println("1. Thêm xe tải,\n" +
//                                " \t2. Thêm ôtô, \n" +
//                                "3. Thêm  xe máy\n");
//                    } while ();
                case 2:
                case 3:
                case 4:
                case 5:
                    System.exit(5);
            }
        } while (true);
    }
}
