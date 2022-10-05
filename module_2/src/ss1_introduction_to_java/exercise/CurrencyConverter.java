package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.println("Nhập vào số tiền USD muốn chuyển: ");
        double usd = Double.parseDouble(scanner.nextLine());
        double vnd = usd * rate;
        System.out.println("Số tiền sau chuyển đổi là: " + vnd );
    }
}
