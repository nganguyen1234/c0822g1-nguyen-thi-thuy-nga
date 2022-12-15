package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SoLonNhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        int iMax = findIndexMax(list);
        int isDeleted = 0;
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(iMax).equals(list.get(i))){
                list.remove(i);
                isDeleted++;
            }
        }
        System.out.println(findIndexMax(list)+isDeleted);
    }
    public static int findIndexMax(List<Integer> list){
        int max = list.get(0);
        int index = 0;
        for (int i = 0; i < list.size() ; i++) {
            if (max<list.get(i)){
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
}
