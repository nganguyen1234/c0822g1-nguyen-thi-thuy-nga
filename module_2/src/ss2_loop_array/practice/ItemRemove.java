package ss2_loop_array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ItemRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("nhập vào phần tử thứ " + i);
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng vừa nhập là: " + Arrays.toString(arr));
        boolean check = false;
        System.out.print("Nhập số muốn xóa: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                check = true;
                System.out.println("số muốn xóa nằm ở vị trí " + index);
                System.arraycopy(arr, i + 1, arr, i, arr.length - 1 - i);
                arr[arr.length - 1] = 0;
                i--;
            }
            index++;
        }
        if (!check) {
            System.out.println("không tồn tại số cần tìm trong mảng");
        } else {
            System.out.println("Mảng sau khi xóa là: " + Arrays.toString(arr));
        }
    }
}
