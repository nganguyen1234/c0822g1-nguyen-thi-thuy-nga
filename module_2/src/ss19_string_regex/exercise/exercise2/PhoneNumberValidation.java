package ss19_string_regex.exercise.exercise2;

import java.util.Scanner;

public class PhoneNumberValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số điện thoại muốn kiếm tra");
        String phoneNumber = scanner.nextLine();
        checkPhoneNumber(phoneNumber);
    }

    private static void checkPhoneNumber(String phoneNumber) {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        if (phoneNumber.matches(regex)) {
            System.out.println("Số điện thoại hợp lệ");
        } else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }
}
