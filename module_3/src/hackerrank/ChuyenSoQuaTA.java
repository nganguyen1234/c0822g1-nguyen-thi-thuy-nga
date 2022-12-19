//package hackerrank;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ChuyenSoQuaTA {
//    public static void main(String[] args) {
//
//    }
//
//    public static String solve(int n) {
//        // Write your code here
//        Map<Integer, String> million = new HashMap<>();
//        million.put(null, "");
//        million.put(1, "One million");
//        million.put(2, "Two million");
//        million.put(3, "Three million");
//        million.put(4, "Four million");
//        million.put(5, "Five million");
//        million.put(6, "Six million");
//        million.put(7, "Seven million");
//        million.put(8, "Eight million");
//        million.put(9, "Nine million");
//
//        Map<Integer, String> thousand = new HashMap<>();
//        thousand.put(null, "");
//        thousand.put(1, "One thousand");
//        thousand.put(2, "Two thousand");
//        thousand.put(3, "Three thousand");
//        thousand.put(4, "Four thousand");
//        thousand.put(5, "Five thousand");
//        thousand.put(6, "Six thousand");
//        thousand.put(7, "Seven thousand");
//        thousand.put(8, "Eight thousand");
//        thousand.put(9, "Nine thousand");
//
//        Map<Integer, String> hundreds = new HashMap<>();
//        hundreds.put(null, "");
//        hundreds.put(1, "One hundred");
//        hundreds.put(2, "Two hundred");
//        hundreds.put(3, "Three hundred");
//        hundreds.put(4, "Four hundred");
//        hundreds.put(5, "Five hundred");
//        hundreds.put(6, "Six hundred");
//        hundreds.put(7, "Seven hundred");
//        hundreds.put(8, "Eight hundred");
//        hundreds.put(9, "Nine hundred");
//
//        Map<Integer, String> tens = new HashMap<>();
//        tens.put(null, "");
//        tens.put(10, "Ten");
//        tens.put(11, "Eleven");
//        tens.put(12, "Twelve");
//        tens.put(13, "Thirteen");
//        tens.put(14, "Fourteen");
//        tens.put(15, "Fifteen");
//        tens.put(16, "Sixteen");
//        tens.put(17, "Seventeen");
//        tens.put(18, "Eighteen");
//        tens.put(19, "Nineteen");
//        tens.put(20, "Twenty");
//        tens.put(3, "Thirty");
//        tens.put(4, "Forty");
//        tens.put(5, "Fifty");
//        tens.put(6, "Sixty");
//        tens.put(7, "Seventy");
//        tens.put(8, "Eighty");
//        tens.put(9, "Ninety");
//
//        Map<Integer, String> number = new HashMap<>();
//        number.put(0, "Zero");
//        number.put(1, "One");
//        number.put(2, "Two");
//        number.put(3, "Three");
//        number.put(4, "Four");
//        number.put(5, "Five");
//        number.put(6, "Six");
//        number.put(7, "Seven");
//        number.put(8, "Eight");
//        number.put(9, "Nine");
//
//        if (n < 10) {
//            return number.get(n);
//        } else if (n <= 20) {
//            return tens.get(n);
//        } else if (n <= 100) {
//
//            if (n % 10 == 0) {
//                return tens.get(n / 10);
//            } else {
//                String w = "";
//                w += tens.get(n / 10) + " and " + number.get(n % 10).toLowerCase();
//                return w;
//            }
//
//        } else if (n < 1000) {
//            if (n % 100 == 0) {
//                return hundreds.get(n / 100);
//            } else if (n % 10 == 0) {
//                String w = "";
//                w += hundreds.get(n / 100) + number.get((n % 100) / 10).toLowerCase();
//                return w;
//            } else {
//                String w = "";
//                w += hundreds.get(n / 100) + tens.get((n % 100) / 10).toLowerCase() + " and " + number.get(n % 10).toLowerCase();
//                return w;
//            }
//        } else if (n < 10000) {
//            if (n % 1000 == 0) {
//                return thousand.get(n / 1000);
//            } else if (n % 100 == 0) {
//                String w = "";
//                w += thousand.get(n / 1000) + hundreds.get((n % 100) / 100).toLowerCase();
//                return w;
//            } else if (n % 10 == 0) {
//                String w = "";
//                w += thousand.get(n / 1000) + hundreds.get((n % 100) / 100).toLowerCase() + " and " + tens.get((n % 100) % 10).toLowerCase();
//                return w;
//            } else {
//                String w = "";
//                w += hundreds.get(n / 100) + tens.get((n % 100) / 10).toLowerCase() + " and " + number.get(n % 10).toLowerCase();
//                return w;
//            }
//        }else if (n < 10000) {
//            if (n % 1000 == 0) {
//                return thousand.get(n / 1000);
//            } else if (n % 100 == 0) {
//                String w = "";
//                w += thousand.get(n / 1000) + hundreds.get((n % 100) / 100).toLowerCase();
//                return w;
//            } else if (n % 10 == 0) {
//                String w = "";
//                w += thousand.get(n / 1000) + hundreds.get((n % 100) / 100).toLowerCase() + " and " + number.get((n % 100) % 10).toLowerCase();
//                return w;
//            } else {
//                String w = "";
//                w += hundreds.get(n / 100) + tens.get((n % 100) / 10).toLowerCase() + " and " + number.get(n % 10).toLowerCase();
//                return w;
//            }
//
//        return null;
//    }
//}
