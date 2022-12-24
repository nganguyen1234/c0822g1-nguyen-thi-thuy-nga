package hackerrank;

public class SoDu {
    public static void main(String[] args) {
//        System.out.println(solve(125,5,29));
        System.out.println(Math.pow(45,536));
        long num =1 ;
        for (int i = 0; i < 536 ; i++) {
            num *= 45;
        }
        System.out.println(num);
    }
    public static int solve(int B, int P, int M) {
        // Write your code here
double soChia = Math.pow(B,P);
return (int) (soChia%M);
    }
}
