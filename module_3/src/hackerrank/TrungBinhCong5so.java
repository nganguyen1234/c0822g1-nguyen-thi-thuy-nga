package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TrungBinhCong5so {

//    public static void main(String[] args) {
//List<Integer> arr = new ArrayList<>();
//arr.add(5);
//        for (int i = 1; i <= 5; i++) {
//            arr.add(i);
//        }
//        System.out.println(solve(arr));}
public static void main(String[] args) {
    System.out.println(Float.parseFloat("42312312.13"));
}

    public static List<Integer> solve(List<Integer> arr) {

        int sum = 0;
        int count1 = 0;
        for (int i = 1; i < arr.size(); i++) {
            sum += arr.get(i);
            count1++;
        }
        List<Integer> resultList = new ArrayList<>();
        if (count1==0){
            resultList.add(0);
            resultList.add(0);
            return resultList;
        }
        int avg = sum / count1;

        resultList.add(avg);
        int count = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < avg) {
                count++;
            }
        }
        resultList.add(count);
        return resultList;
    }
}
