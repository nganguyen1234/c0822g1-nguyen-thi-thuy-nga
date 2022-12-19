package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TrungViHaiMang {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
//        arr2.add(4);
        String s = solve(arr1, 2, arr2, 1);
        System.out.println(s);
    }

    public static String solve(List<Integer> arr1, int m, List<Integer> arr2, int n) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(arr1.get(i));
        }
        for (int i = 0; i < n; i++) {
            list.add(arr2.get(i));
        }
        list.sort((o1, o2) -> o1 - o2);
        if ((m + n) % 2 != 0) {
            String result = String.valueOf(list.get((m + n) / 2));
            result += ".00000";
            return result;
        } else {
            double num1 = (double) (list.get((m + n) / 2 - 1) + list.get((m + n) / 2)) / 2;
            String num2 = "";
            num2 += num1;
            if (num2.split("\\.")[1].length() == 1) {
                num2 += "0000";
            } else if (num2.split("\\.")[1].length() == 2){
                num2 += "000";
            } else if (num2.split("\\.")[1].length() == 3){
                num2 += "00";
            }
            if (num1 == (int) num1) {
                num2 += ".00000";
            }
            return num2;
        }
    }
}
