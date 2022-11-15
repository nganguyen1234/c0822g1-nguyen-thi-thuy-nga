package giai_thuat.exercise7_tong_day_phan_so.mau_tang_dan;

import case_study.furama_resort.common.ExceptionHandling;

public class Test {
    public static void main(String[] args) {

        System.out.println("Nhập vào n");
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        int size = exceptionHandling.enterPositiveInteger();
        int mauSo=0;
        double sum = 0;
        for (int i = 1; i <= size ; i++) {
            mauSo += i;
            sum += (double) 1/mauSo;
        }
        System.out.println(sum);
    }
}
