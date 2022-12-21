package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SNTIn2dArray {
    public static void main(String[] args) {
List<Integer> list1 = new ArrayList<>();
list1.add(1);
list1.add(2);
list1.add(8);
list1.add(43);
List<Integer> list2 = new ArrayList<>();
list2.add(9);
list2.add(4);
list2.add(53);
list2.add(7);
List<Integer> list3 = new ArrayList<>();
list3.add(11);
list3.add(6);
list3.add(4);
list3.add(0);
List<Integer> list4 = new ArrayList<>();
list4.add(1);
list4.add(2);
list4.add(6);
list4.add(51);
List<List<Integer>> r = new ArrayList<>();
r.add(list1);
r.add(list2);
r.add(list3);
r.add(list4);
        System.out.println(solve(r));

    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static List<Integer> solve(List<List<Integer>> a){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a.size() ; i++) {
            for (int j = 0; j < a.get(i).size() ; j++) {
                int number = a.get(i).get(j);
                if (isPrime(number)){
                    if (!integers.contains(number)){
                        integers.add(number);
                    }
                }
            }
        }
        if (integers.isEmpty()){
            integers.add(-1);
        }
        integers.sort((o1, o2) -> o1 - o2);
        return integers;
    }
}
