package ss2_loop_array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ColumnSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        int n;
        do {
            System.out.println("nhập vào số hàng");
            m = Integer.parseInt(scanner.nextLine());
            if (m < 0) {
                System.out.println("thông tin không hợp lệ. Vui lòng nhập lại");
            }
        } while (m < 0);
        do {
            System.out.println("nhập vào số cột");
            n = Integer.parseInt(scanner.nextLine());
            if (n < 0) {
                System.out.println("thông tin không hợp lệ. Vui lòng nhập lại");
            }
        } while (n < 0);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" nhập vào giá trị phần tử thứ [" + i + "][" + j + "] ");
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Ma trận vừa nhập là: ");
        for (int[] items : arr) {
            for (int item : items) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }

        int column;
        do {
            System.out.println("Nhập vị trí cột bạn muốn tính tổng");
            column = Integer.parseInt(scanner.nextLine());
            if (column > n || column < 0) {
                System.out.println("vị trí cột không hợp lệ. Vui lòng nhập lại ");
            }
        } while (column > n || column < 0);
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i][column];
        }
        System.out.println(" tổng cần tìm là: " + sum);
    }
}
