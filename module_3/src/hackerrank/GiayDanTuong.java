package hackerrank;

import java.util.List;

public class GiayDanTuong {
    public static void main(String[] args) {

        System.out.println();
    }
    public static int solve(List<List<Integer>> arr, int m, int n) {
        // Write your code here
        int lanCat =0;
        for (int i = 0; i < n; i++) {
            int index =1;
            while (index<m){
                if (arr.get(index).get(i)==0){
                    if (index<m-1){
                        if (arr.get(index+1).get(i)==1){
                            lanCat++;
                        }
                    }else {
                            lanCat++;
                    }
                }
                index++;
            }

//            for (int j = index; j < m+1; j++) {
//                index = 1;
//                if (arr.get(j).get(i)==0){
//                    index++;
//                    if (j<m){
//                        if (arr.get(j+1).get(i)==1){
//                            lanCat++;
//                        }
//                    }
//                }
//            }

        }
        return lanCat;
    }
}
