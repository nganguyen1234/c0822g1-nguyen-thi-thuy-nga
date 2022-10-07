package ss2_loop_array.practice;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "Hello World";
        System.out.println("nhập vào ký tự cầm tìm: ");
        char[] arr = str.toCharArray();
        char character = scanner.nextLine().charAt(0);
        int count = 0;
        for (char item : arr) {
            if (item == character) {
                count++;
            }
        }
        System.out.println("ký tự đã nhập xuất hiện " + count + " lần");
    }
}
