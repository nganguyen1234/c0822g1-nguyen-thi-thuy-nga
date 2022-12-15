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
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    for (int k = list.get(i)+1; k < list.get(j); k++) {
                        resultList.add(k);
                        return resultList;
                    }
                }
            }
        }
       return null;
    }
}