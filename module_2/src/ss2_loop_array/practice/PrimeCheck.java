package ss2_loop_array.practice;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        int n = 2;
        boolean check = true;
        int count = 0;
        while (count < 20) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
            if (check) {
                System.out.println(n);
                count++;
            }
            n++;
        }
    }
}
