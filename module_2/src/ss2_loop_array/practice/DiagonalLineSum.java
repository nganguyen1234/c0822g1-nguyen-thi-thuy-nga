package ss2_loop_array.practice;

import java.util.Scanner;

public class DiagonalLineSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        do {
            System.out.println("nhập vào số hàng và số cột của ma trận vuông");
            m = Integer.parseInt(scanner.nextLine());
            if (m < 0) {
                System.out.println("thông tin không hợp lệ. Vui lòng nhập lại");
            }
        } while (m < 0);

        double[][] arr = new double[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" nhập vào giá trị phần tử thứ [" + i + "][" + j + "] ");
                arr[i][j] = Double.parseDouble(scanner.nextLine());
            }
        }
        System.out.println("Ma trận vừa nhập là: ");
        for (double[] items : arr) {
            for (double item : items) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
        double sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(" tổng đường chéo của ma trận cần tìm là: " + sum);
    }
}
