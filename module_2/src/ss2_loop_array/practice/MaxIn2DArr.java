package ss2_loop_array.practice;

import java.util.Scanner;

public class MaxIn2DArr {
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
        int max = arr[0][0];
        int row = 0;
        int column = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    column = j;
                    row = i;
                }
            }
            System.out.println();
        }
        System.out.println("giá trị lớn nhất của mảng là: " + max + " tại vị trí là: " + " hàng " + row + " cột " + column);
    }
}


