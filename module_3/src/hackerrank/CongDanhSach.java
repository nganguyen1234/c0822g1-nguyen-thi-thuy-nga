package hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CongDanhSach {
    public static void main(String[] args) {
//        System.out.println(solve("9999999", "9999"));
        String n = "01";
        System.out.println(Arrays.toString(n.split("")));
    }

    public static String solve(String a, String b) {
        String[] str1 = a.split("");
        String[] str2 = b.split("");
        if ((str1[0].equals("0")&&str1.length!=1)||(str2[0].equals("0")&&str2.length!=1)){
            return null;
        }
        String num1 = "";
        for (int i = str1.length - 1; i >= 0; i--) {
            num1 += str1[i];
        }
        String num2 = "";
        for (int i = str2.length - 1; i >= 0; i--) {
            num2 += str2[i];
        }
        int num3 = Integer.parseInt(num1) + Integer.parseInt(num2);
        String[] n = String.valueOf(num3).split("");
        String finalStr = "";
        for (int i = n.length - 1; i >= 0; i--) {
            finalStr += n[i];
        }
        return finalStr;
    }
}
