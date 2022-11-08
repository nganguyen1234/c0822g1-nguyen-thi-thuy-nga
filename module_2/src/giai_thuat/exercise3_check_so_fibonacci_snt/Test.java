package giai_thuat.exercise3_check_so_fibonacci_snt;

import case_study.furama_resort.common.ExceptionHandling;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        NumberCheck numberCheck = new NumberCheck();
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        System.out.println("Nhập vào một số nguyên");
        int number = exceptionHandling.enterPositiveInteger();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            if (numberCheck.fibonacciCheck(i)&& numberCheck.primeCheck(i)) {
                list.add(i);
            }
        }
        for (int item : list) {
            System.out.println(item);
        }
    }
}
