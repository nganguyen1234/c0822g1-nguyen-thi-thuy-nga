package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ChuoiPalindrome {
    public static void main(String[] args) {

    }
    public static String solve(String s) {
        String letterCheck = "[a-zA-Z1-9]";
        String[] strings = s.toLowerCase().split("");
        List<String> list = new ArrayList<>();
        for(int i = 0; i<strings.length;i++){
            if(strings[i].matches(letterCheck)){
                list.add(strings[i]);
            }
        }
        for(int i = 0; i<list.size();i++){
            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return "False";

            }
        }
        return "True";
    }
}
