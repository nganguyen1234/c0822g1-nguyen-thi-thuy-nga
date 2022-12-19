package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DuongDanToiThieu {
    public static void main(String[] args) {
List<List<Integer>> arr = new ArrayList<>();
List<Integer> list1 = new ArrayList<>();
list1.add(1);
    }

    public static int solve(List<List<Integer>> arr, int m, int n) {
        // Write your code here
        int sum1 = 0;
        int h = 1;
        int c = 0;
        while (h <= m && c <= n) {
            sum1 += arr.get(h).get(c);

            if (h == m) {
                c++;
            }else {
                h++;
            }

        }
        int sum2 =0;
        int h1 =1;
        int c1=0;
        while (h1 <= m && c1 <= n) {
            sum2 += arr.get(h).get(c);

            if (c1 == n) {
                h1++;
            }else {
                c1++;
            }
        }
        if (sum1>sum2){
            return sum1;
        }
        return sum2;
    }

}
