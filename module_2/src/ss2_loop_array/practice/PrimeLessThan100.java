package ss2_loop_array.practice;


public class PrimeLessThan100 {
    public static void main(String[] args) {
        int n = 2;
        boolean check = true;
        while (n < 100) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
            if (check) {
                System.out.println(n);
            }
            n++;
        }
    }
}
