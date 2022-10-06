package ss2_loop_array.practice;

import java.util.Arrays;

public class
ArrayMerge {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        int n = arr1.length + arr2.length;
        int[] arr3 = new int[n];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, n - arr1.length);
        System.out.println("mảng sau khi được gộp là: " + Arrays.toString(arr3));
    }
}
