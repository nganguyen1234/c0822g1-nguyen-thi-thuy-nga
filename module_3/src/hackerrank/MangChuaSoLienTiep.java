package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MangChuaSoLienTiep {
    public static void main(String[] args) {
        System.out.println(findIncreaseArray("6 2 3 8"));
    }

    public static List<Integer> findIncreaseArray(String s) {
        String[] strings = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        List<Integer> resultList = new ArrayList<>();
        int min = list.get(0);
        int max = list.get(0);
        for (int i = 0; i < list.size() ; i++) {
            if (min > list.get(i)){
                min = list.get(i);
            }
            if (max<list.get(i)){
                max = list.get(i);
            }
        }
        for (int i =min + 1; i < max ; i++) {
            if (!list.contains(i)){
                resultList.add(i);
            }
        }
       return resultList;
    }
}