package exercise2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Enter name");
        Scanner scanner = new Scanner(System.in);
        CodeGymUtil codeGymUtil = new CodeGymUtil();
        String name = scanner.nextLine();
        try {
            if (codeGymUtil.isValidClassName(name)) {
                System.out.println("Valid name");
            }
        } catch (InvalidFormatCGNameException e) {
            System.out.println(e.getMessage());
        }
    }
}
