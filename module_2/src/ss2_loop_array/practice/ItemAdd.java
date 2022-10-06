package ss2_loop_array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ItemAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 4, 6, 23, 5, 0, 0, 2, 3, 0};
        System.out.println("Nhập vào số muốn chèn");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào vị trí muốn chèn");
        int index = Integer.parseInt(scanner.nextLine());
        if (index <= -1 || index > arr.length - 1) {
            System.out.println("không chèn được phần tử vào mảng");
        } else {
            System.arraycopy(arr, index, arr, index + 1, arr.length - 1 - index);
            arr[index] = number;
            System.out.println("mảng sau khi thêm phần tử là: " + Arrays.toString(arr));
        }
    }
}
