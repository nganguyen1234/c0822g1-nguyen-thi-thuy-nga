package ss14_sort_algorithm.exercise.exercise2;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        int key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }
}
