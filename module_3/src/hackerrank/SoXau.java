package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SoXau {
    public static void main(String[] args) {
        System.out.println(solve(6));
    }
    public static String solve(int n) {
        // Write your code here
        if(n==1){
            return "True";
        }
        if(n%2==0){
            while(n%2==0){
                n/=2;
            }
        }
        if(n%3==0){
            while(n%3==0){
                n/=3;
            }
        }
        if(n%5==0){
            while(n%5==0){
                n/=5;
            }
        }
        if(n!= 1){
            return "False";
        }
        return "True";
    }

}
