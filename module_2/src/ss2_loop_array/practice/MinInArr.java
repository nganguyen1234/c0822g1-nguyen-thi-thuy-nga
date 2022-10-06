package ss2_loop_array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MinInArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhập vào số lượng phần tử của mảng: ");
            n = Integer.parseInt(scanner.nextLine());
            if (n <= 0) {
                System.out.println("Gía trị không hợp lệ. Vui lòng nhập lại");
            }
        } while (n <= 0);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập vào phần tử thứ " + i +" ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(" Mảng vừa nhập là: " + Arrays.toString(arr));
        int min = arr[0];
        for (int item : arr) {
            if (item < min) {
                min = item;
            }
        }
        System.out.println("giá trị nhỏ nhất của mảng là " + min);
    }
}
