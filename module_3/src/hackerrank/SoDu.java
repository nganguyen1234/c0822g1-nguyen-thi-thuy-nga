package hackerrank;

public class SoDu {
    public static void main(String[] args) {
        System.out.println(solve(125,5,29));
    }
    public static int solve(int B, int P, int M) {
        // Write your code here
double soChia = Math.pow(B,P);
return (int) (soChia%M);
    }
}
