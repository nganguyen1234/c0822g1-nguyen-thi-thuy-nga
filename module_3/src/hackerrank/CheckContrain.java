package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckContrain {
    public static void main(String[] args) {
        System.out.println(checkContrain("abcd","badc"));
    }

    public static boolean checkContrain(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        String[] a1 = s1.split("");
        String[] a2 = s2.split("");
        int index = 0;
        String temp;
        String str1 ="";
        while (index < a2.length) {
            int soLanDoi = 0;
            for (int i = index; i < s2.length(); i++) {
                if (a2[index].equals(a1[i])) {
                    temp = a1[index];
                    a1[index] = a2[index];
                    a1[i] = temp;
                    str1+=a1[index];
                    index++;
                    soLanDoi++;

                    break;
                }
            }
            if (soLanDoi==0){
                return false;
            }
        }
        if (str1.equals(s2)){
            return true;
        }
        return false;
    }
}
