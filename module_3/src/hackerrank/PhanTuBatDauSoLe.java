package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class PhanTuBatDauSoLe {
    public static void main(String[] args) {

    }
    public static List<Integer> getOddHeadNumbers(String s) {
        // Write your code here
        String[] str = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < str.length; i++){

            if(Integer.parseInt(String.valueOf(str[i].charAt(0)))%2!=0){
                list.add(Integer.parseInt(str[i]));
            }
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }
}
