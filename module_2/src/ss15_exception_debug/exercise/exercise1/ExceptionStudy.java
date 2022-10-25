package ss15_exception_debug.exercise.exercise1;

import java.util.Scanner;

public class ExceptionStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side1;
        int side2;
        int side3;
        do {
            System.out.println("Nhập vào độ dài cạnh thứ nhất của tam giác");
            side1 = Integer.parseInt(scanner.nextLine());
            try {
                triangleCheck(side1);
            } catch (IllegalTriangleException e) {
                e.printStackTrace();
                System.out.println("Vui lòng nhập lại giá trị hợp lệ");
            }
        } while (side1 <= 0);
        do {
            System.out.println("Nhập vào độ dài cạnh thứ hai của tam giác");
            side2 = Integer.parseInt(scanner.nextLine());
            try {
                triangleCheck(side2);
            } catch (IllegalTriangleException e) {
                e.printStackTrace();
                System.out.println("Vui lòng nhập lại giá trị hợp lệ");
            }
        } while (side2 <= 0);
        do {
            System.out.println("Nhập vào độ dài cạnh thứ ba của tam giác");
            side3 = Integer.parseInt(scanner.nextLine());
            try {
                triangleCheck(side3);
            } catch (IllegalTriangleException e) {
                e.printStackTrace();
                System.out.println("Vui lòng nhập lại giá trị hợp lệ");
            }
        } while (side3 <= 0);
        try {
            triangleCheck(side1, side2, side3);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }

    public static void triangleCheck(int side) throws IllegalTriangleException {
        if (side <= 0) {
            throw new IllegalTriangleException("cạnh tam giác không thể nhận giá trị âm hoặc bằng 0");
        }
    }

    public static void triangleCheck(int side1, int side2, int side3) throws IllegalTriangleException {
        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side1 + side3 <= side2) {
            throw new IllegalTriangleException("tổng hai cạnh không lớn hơn hai cạnh còn lại");
        }
    }
}
