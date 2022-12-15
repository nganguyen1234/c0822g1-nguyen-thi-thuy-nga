package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CapSoCong {
    public static void main(String[] args) {
        System.out.println(checkPlusLevel("1 4 7"));
    }
    public static boolean checkPlusLevel(String s) {
        String[] strings = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        int congSai = list.get(1) - list.get(0);
        for (int i = 0; i < list.size()-1 ; i++) {
            if (list.get(i+1)-list.get(i)!= congSai){
                return false;
            }
        }
        return true;
    }
}
