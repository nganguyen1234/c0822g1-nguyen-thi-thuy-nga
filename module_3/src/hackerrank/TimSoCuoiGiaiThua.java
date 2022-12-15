package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TimSoCuoiGiaiThua {
    public static void main(String[] args) {
        System.out.println(findLastNumber(12));
    }

    public static int findLastNumber(int a) {
        int giaiThua = 1;
        for (int i = 1; i <= a; i++) {
            giaiThua *= i;
        }
        List<Integer> list = new ArrayList<>();
        int digit;
        while (giaiThua > 0) {
            digit = giaiThua % 10;
            list.add(digit);
            giaiThua = giaiThua / 10;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                return list.get(i);
            }
        }

        return -1;
    }

}
