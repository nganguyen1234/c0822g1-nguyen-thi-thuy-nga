package ss14_sort_algorithm.exercise.exercise1;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của màng:");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào giá trị phần tử thứ " + (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng ban đầu là:\n" + Arrays.toString(arr));
        int key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
            System.out.println("Mảng sau khi sắp xếp lần " + i + ":\n" + Arrays.toString(arr));
        }
        System.out.println("Mảng sau khi sắp xếp là: \n" + Arrays.toString(arr));
    }
}
