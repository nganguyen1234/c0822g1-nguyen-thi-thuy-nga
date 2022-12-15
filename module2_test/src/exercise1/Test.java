package exercise1;

public class Test {
    public static void main(String[] args) {
//        for (int i = 1; i < 100; i++) {
//            if (squareNumberCheck(i)) {
//                System.out.println(i);
//            }
//        }
        System.out.println(solve(125,5,29));
    }

    public static boolean squareNumberCheck(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
    public static int solve(int B, int P, int M) {
        // Write your code here
        int soChia = (int)Math.pow(B,P);
//        for(int i = 0; i < P; i++ ){
//            soChia *= B;
//        }
        return soChia%M;
    }
}
