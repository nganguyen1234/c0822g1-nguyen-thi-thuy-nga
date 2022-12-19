package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoLonNhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        System.out.println(findIndex(list));
//        int iMax = findIndexMax(list);
//        int isDeleted = 0;
//        for (int i = 0; i < list.size() ; i++) {
//            if (list.get(iMax).equals(list.get(i))){
//                list.remove(i);
//                isDeleted++;
//            }
//        }
//        System.out.println(findIndexMax(list)+isDeleted);
    }

    public static int findIndex(List<Integer> list) {
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i));
        }
        if (list.size() <= 2) {
            return -1;
        }
        list.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(0))) {
                return list1.indexOf(list.get(i));
            }
        }
        return -1;
    }
}
