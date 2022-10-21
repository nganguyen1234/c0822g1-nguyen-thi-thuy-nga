package ss13_search_algorithm.exercise.exercise2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhạp vào số lương phần tử của mảng:");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào giá trị phần tử thứ " + (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(arr);
        System.out.println("Nhập vào giá trị muốn tìm");
        int value = Integer.parseInt(scanner.nextLine());
        System.out.println(binarySearch(arr, 0, arr.length - 1, value));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            }
            if (value > array[middle]) {
                return binarySearch(array, middle + 1, right, value);
            }
            return binarySearch(array, left, middle - 1, value);
        }
        return -1;
    }
}

