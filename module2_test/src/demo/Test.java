package demo;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      int x = Integer.parseInt(scanner.nextLine());
 int result = solve(x);
        System.out.println(result);
    }
    private static Integer solve(int x){
        String str = String.valueOf(x);
        char max = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>max){
                max = str.charAt(i);
            }
        }
        String pfNumber = "";
        for (int i = 0; i < str.length(); i++) {
            pfNumber += max;
        }
        int result = Integer.parseInt(pfNumber) - x;
        return result;
    }
}
