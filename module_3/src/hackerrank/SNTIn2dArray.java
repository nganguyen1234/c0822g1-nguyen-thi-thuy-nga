package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SNTIn2dArray {
    public static void main(String[] args) {

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
