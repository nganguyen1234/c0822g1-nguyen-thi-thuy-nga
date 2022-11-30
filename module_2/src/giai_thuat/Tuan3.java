package giai_thuat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tuan3 {
    public static void main(String[] args) {
        char[] list = solution("abcbdcef");
        System.out.println(Arrays.toString(list));
    }

    private static char[] solution(String str) {
        List<String> list = new ArrayList<>();
        String[] strings = str.split("");
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        List<Character> resultList = new ArrayList<>();

        int deleted = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (list.get(i).equals(list.get(j))) {
                    count++;
                    index = j;
                    list.remove(j);
                    deleted++;
                    j--;
                }
            }
            if (count > 1) {
                resultList.add(str.charAt(index + deleted - 1));
            }
        }
        char[] finalList = new char[resultList.size()];
        for (int i = 0; i < finalList.length; i++) {
            finalList[i] = resultList.get(i);
        }
        return finalList;
    }
// private static char[] solution(String str) {
//
//        String[] strings = str.split("");
//
//     List<String> list = new ArrayList<>();
//        for (int i = 0; i < strings.length; i++) {
//            list.add(strings[i]);
//        }
//
//        List<Character> resultList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            int count = 1;
//            for (int j = 0; j < list.size(); j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (list.get(i).equals(list.get(j))) {
//                    count++;
//                    if (count==2){
//                        if (!resultList.contains(list.get(j)))
//                        resultList.add(str.charAt(j));
//                    }
//
//                }
//            }
//        }
//        char[] finalList = new char[resultList.size()];
//        for (int i = 0; i < finalList.length ; i++) {
//            finalList[i] = resultList.get(i);
//        }
//        return finalList;
//}

}
