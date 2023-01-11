package giai_thuat.mau_tang_dan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoNgu {
    public static void main(String[] args) {
        String[] strings = {"a"};
        List<List<String>> list = solve(strings);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static List<List<String>> solve(String[] strArray) {
        List<String> strList = new ArrayList<>();
        strList.addAll(Arrays.asList(strArray));
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            List<String> list1 = new ArrayList<>();
            String word1 = strList.get(i);
            list1.add(word1);
            strList.remove(i);
            for (int j = 0; j < strList.size(); j++) {
                String word2 = strList.get(j);
                if (checkWords(word1, word2)) {
                    list1.add(word2);
                    strList.remove(j);
                    j--;
                }
            }
            list.add(list1);
            i--;
        }
        return list;
    }

    private static boolean checkWords(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        List<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(word1.split("")));
        List<String> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(word2.split("")));
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    list1.remove(i);
                    list2.get(j);
                    i--;
                    j--;
                    break;
                }
            }
        }
        if (list1.size() == 0) {
            return true;
        }
        return false;
    }
}
