package hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SoVong {
    public static void main(String[] args) {
        System.out.println(countNumberCircle(9,13));
    }

    public static int countNumberCircle(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (isNumberCircle(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isNumberCircle(int number) {
        if (number < 10 && number > 0) {
            return true;
        }
        List<Integer> list = Arrays.asList(number);
        String[] strings = list.get(0).toString().split("");
        if (strings[0].equals(strings[strings.length - 1])) {
            return true;
        }
        return false;
    }
}
