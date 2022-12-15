package hackerrank;

import java.util.*;

public class DemSoKiTu {
    public static void main(String[] args) {
        System.out.println(countDiffChar("caaabdb"));
    }
    public static int countDiffChar(String s) {
      String[] strings = s.split("");
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < strings.length ; i++) {
            map.put(strings[i],1);
        }
        return map.keySet().size();
    }

}
