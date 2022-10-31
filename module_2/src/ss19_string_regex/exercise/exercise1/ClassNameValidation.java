package ss19_string_regex.exercise.exercise1;

import java.util.Scanner;

public class ClassNameValidation {
    public static void main(String[] args) {
        System.out.println("Nhập vào tên lớp muốn kiểm tra");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        checkName(className);
    }

    private static void checkName(String className) {
        String regex = "^[ACP]\\d{4}[GHIKLM]$";
        if (className.matches(regex)) {
            System.out.println("Tên lớp hợp lệ");
        } else {
            System.out.println("Tên lớp không hợp lệ");
        }
    }
}
