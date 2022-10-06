package ss2_loop_array.practice;


public class PrimeLessThan100 {
    public static void main(String[] args) {
        int N = 2;
        boolean check = true;
        while (N < 100) {
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
            if (check) {
                System.out.println(N);
            }
            N++;
        }
    }
}
