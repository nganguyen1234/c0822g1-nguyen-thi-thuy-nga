package giai_thuat.exercise6_check_mang_con;

import case_study.furama_resort.common.ExceptionHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng thứ nhất");
        int size1 = exceptionHandling.enterPositiveInteger();
        List<Integer> firstList = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            System.out.println("Nhập vào giá trị phần tử thứ" + (i + 1));
            firstList.add(exceptionHandling.enterPositiveInteger());
        }
        System.out.println("Nhập số phần tử của mảng thứ hai");
        int size2 = exceptionHandling.enterPositiveInteger();
        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            System.out.println("Nhập vào giá trị phần tử thứ" + (i + 1));
            secondList.add(exceptionHandling.enterPositiveInteger());
        }
        int count = 0;
        for (int i = 0; i < size1; i++) {
            for (int j = count; j < size2; j++) {
                if (firstList.get(i).equals(secondList.get(j))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count == size2);
    }
}
