//package giai_thuat.exercise2_dem_so_lan_xuat_hien;
//
//import case_study.furama_resort.common.ExceptionHandling;
//import giai_thuat.common.CompleteArray;
//
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Test {
//    public static void main(String[] args) {
//        CompleteArray<Integer> completeArray = new CompleteArray();
//        ExceptionHandling exceptionHandling = new ExceptionHandling();
//        System.out.println("Nhập vào size của mảng");
//        List<Integer> list = completeArray.completeIntegerArray(exceptionHandling.enterPositiveInteger());
//        Map<Integer,Integer> map = new TreeMap<>();
//        for (Integer item:list) {
//            if (map.containsKey(item)){
//                map.put(item,map.get(item)+1);
//            }else {
//                map.put(item,1);
//            }
//        }
//        System.out.println(map);
//    }
//}
