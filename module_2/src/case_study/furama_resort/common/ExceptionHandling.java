package case_study.furama_resort.common;

import java.util.Scanner;

public class ExceptionHandling {
    private final Scanner scanner = new Scanner(System.in);

    public int enterPositiveInteger() {
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number;
                }
                System.out.println("Try again!!!");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
//                System.out.println("Please enter a positive integer");
            }
        } while (true);
    }

    public double enterDouble() {
        double number;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number > 0) {
                    return number;
                }
                System.out.println("Try again!!!");

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public double enterArea() {
        double area;
        do {
            try {
                area = Double.parseDouble(scanner.nextLine());
                if (area > 30) {
                    return area;
                }
                System.out.println("Try again!!!");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public int enterNumberOfPeople() {
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 20) {
                    return number;
                }
                System.out.println("Try again!!!");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
