package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DauTuNgoaiTe {
    public static void main(String[] args) {

    }
    public static int getMoneyInvestment(String e, int n) {
        if(n==0){
            return 0;
        }
        String[] strings = e.split(" ");
        List<Integer> muaList = new ArrayList<>();
        for(int i = 0; i< strings.length; i+=2){
            muaList.add(Integer.parseInt(strings[i]));
        }
        List<Integer> banList = new ArrayList();
        for(int i = 1; i< strings.length; i+=2){
            banList.add(Integer.parseInt(strings[i]));
        }
        int max = 0;
        int profit = 0;
        for (int i = 0; i < muaList.size() ; i++) {
            for (int j = 0; j < banList.size(); j++) {
                profit = banList.get(j) - muaList.get(i) + n;
                if (profit > max){
                    max = profit;
                }
            }
        }
        return max;
        // Write your code here

    }

}
