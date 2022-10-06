package ss2_loop_array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class
ArrayMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int n = arr1.length + arr2.length;
        int[] arr3 = new int[n];
        for (int i = 0; i < 5; i++) {
            System.out.print("nhập vào phần tử thứ " + i + " của mảng 1 ");
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng 1 vừa nhập là: " + Arrays.toString(arr1));
        for (int i = 0; i < 5; i++) {
            System.out.print("nhập vào phần tử thứ " + i + " của mảng 2 ");
            arr2[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng 2 vừa nhập là: " + Arrays.toString(arr2));

        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, n - arr1.length);
        System.out.println("mảng sau khi được gộp là: " + Arrays.toString(arr3));
    }
}
