package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MangConTrungLap {
    public static void main(String[] args) {
        System.out.println(solve("1 4 5 2 1","1 2 3"));
    }
    public static String solve(String parentString, String childString) {
        // Write your code here
        String[] paStrings = parentString.split(" ");
        List<String> paList = new ArrayList<>();
        paList.addAll(Arrays.asList(paStrings));
        String[] chStrings = childString.split(" ");
        List<String> chList = new ArrayList<>();
        chList.addAll(Arrays.asList(chStrings));
        for(int i = 0; i< chList.size(); i++){
            boolean check = false;
            for(int j = 0; j < paList.size(); j++){
                if(chList.get(i).equals(paList.get(j))){
                    check = true;
                    paList.remove(j);
                    j--;
                    chList.remove(i);
                    i--;
                    break;
                }
            }
            if(!check){
                return "0";
            }
        }
        return "1";
    }
}
