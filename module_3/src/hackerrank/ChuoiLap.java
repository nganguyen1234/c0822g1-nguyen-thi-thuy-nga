package hackerrank;

import java.util.*;

public class ChuoiLap {
    public static void main(String[] args) {
        List<String> content = new ArrayList<>();
        content.add("Welcom!welcom!");
        content.add("Welcom!Welcom!");
        content.add("VOI2019&ACM/ICPC");
        content.add("DANVNG, 9-21/2019");
//        System.out.println(isLoopString(content));
//        System.out.println(tinhSoLanLap("NgaNgaNga","Nga"));
        System.out.println(isLoopString(content));
    }

    public static int isLoopString(List<String> content) {
        // Write your code here
        Map<String,Integer> resultMap = new HashMap<>();
        for (String str:content) {
            String[] strings = str.toLowerCase().split("");

            for (int i = 1; i < strings.length; i++) {
                String subStr = str.substring(0,i);
                String repeat ="";
                for (int j = 0; j < str.length()/i ; j++) {
                    repeat += subStr;
                }
                if (repeat.equals(str)){
                    resultMap.put(subStr,1);
                }
            }
        }
      return resultMap.keySet().size();
    }
//    public static boolean laChuoi(String str) {
//        String[] strings = str.toLowerCase().split("");
//        Map<String,Integer> resultMap = new HashMap<>();
//        for (int i = 0; i < strings.length; i++) {
//           String subStr = str.substring(0,i);
//           String repeat ="";
//            for (int j = 0; j < str.length()/j ; j++) {
//                repeat += subStr;
//            }
//            if (repeat.equals(str)){
//                resultMap.put(subStr,1);
//            }
//        }
//    return true;
//    }
 public static int tinhSoLanLap(String s, String w){
        int count = 0;
     for (int i = 0; i < s.length(); i+= w.length()) {
         count ++;
     }
     return count;
 }


}
