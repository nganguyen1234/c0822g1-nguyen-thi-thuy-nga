package thuc_hanh;

import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year = scanner.nextInt();
        boolean isDivisibleBy4 = year % 4 == 0;
        boolean isALeapYear = false;

        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (!isDivisibleBy100) {
                isALeapYear = true;
            } else {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    isALeapYear = true;
                }
            }
        }
        System.out.println(isALeapYear);
    }
}
