package hackerrank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CongNhiPhan {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String[] strA = new String[s.length()];
//        for (int i = 0; i < strA.length; i++) {
//            strA[i] = String.valueOf(s.charAt(i));
//        }
//        System.out.println(Arrays.toString(strA));
        System.out.println(solve("1010", "1011"));
    }

    public static String solve(String a, String b) {
        // Write your code here
        StringBuffer stringBuffer = new StringBuffer(a);
        String rA = stringBuffer.reverse().toString();

        StringBuffer stringBuffer1 = new StringBuffer(b);
        String rB = stringBuffer1.reverse().toString();
        int soChuSo;
        if (rA.length() > rB.length()) {
            soChuSo = rA.length();
        } else {
            soChuSo = rB.length();
        }
        String[] strA = new String[soChuSo];
        for (int i = 0; i < rA.length(); i++) {
            if (i < rA.length()) {
                strA[i] = String.valueOf(rA.charAt(i));
            } else {
                strA[i] = "0";
            }
        }
        String[] strB = new String[soChuSo];
        for (int i = 0; i < soChuSo; i++) {
            if (i < rB.length()) {
                strB[i] = String.valueOf(rB.charAt(i));
            } else {
                strB[i] = "0";
            }

        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < soChuSo; i++) {
            if (i == soChuSo - 1 && strA[i].equals("1") && strB[i].equals("1")) {
                resultList.add("10");
                continue;
            }
            if (strA[i].equals("0") && strB[i].equals("0")) {
                resultList.add("0");
                continue;
            }
            if (strA[i].equals("1") && strB[i].equals("0")) {
                resultList.add("1");
                continue;
            }
            if (strA[i].equals("0") && strB[i].equals("1")) {
                resultList.add("1");
                continue;
            }
            if (strA[i].equals("1") && strB[i].equals("1")) {
                if (i <= soChuSo - 1) {
                    resultList.add("0");
                    if (strA[i + 1].equals("0")) {
                        strA[i + 1] = "1";
                    } else if (strB[i + 1].equals("0")) {
                        strB[i + 1] = "1";
                    } else if (strA[i + 1].equals("1")) {
                        strA[i + 1] = "0";
                    } else if (strB[i + 1].equals("1")) {
                        strB[i + 1] = "0";
                    }
                }
            }

        }
        String result = "";
        for (int i = resultList.size() - 1; i >= 0; i--) {
            result += resultList.get(i);
        }
        return result;
    }
}
