package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TaoMangPrefix {
    public static void main(String[] args) {
        System.out.println(buildArray("1 2 3"));
    }

    public static List<Integer> buildArray(String s) {
        String[] strings = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        List<Integer> resultList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < list.size() ; i++) {
            sum += list.get(i);
            resultList.add(sum);
        }
        return resultList;
    }
}
