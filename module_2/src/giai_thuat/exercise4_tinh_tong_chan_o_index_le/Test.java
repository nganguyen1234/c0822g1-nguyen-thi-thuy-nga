//package giai_thuat.exercise4_tinh_tong_chan_o_index_le;
//
//import case_study.furama_resort.common.ExceptionHandling;
//import giai_thuat.common.CompleteArray;
//
//import java.util.List;
//
//public class Test {
//    public static void main(String[] args) {
//        CompleteArray completeArray = new CompleteArray();
//        ExceptionHandling exceptionHandling = new ExceptionHandling();
//        int size;
//        do {
//            System.out.println("Nhập vào size của mảng");
//            size = exceptionHandling.enterPositiveInteger();
//            if (size > 50) {
//                System.out.println("Size phải bé hơn 50");
//            }
//        } while (size > 50);
//        List<Integer> list = completeArray.completeIntegerArray(size);
//        int sum=0;
//        int count = 0;
//        for (int i = 0; i < size; i++) {
//            System.out.print(list.get(i)+ "\t");
//            if (i % 2 == 1 && list.get(i) % 2 == 0) {
//                count++;
//                sum += list.get(i);
//            }
//        }
//        System.out.println("tổng cần tìm là: "+ sum/count);
//    }
//}
