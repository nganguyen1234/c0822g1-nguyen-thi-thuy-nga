package exercise1;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (squareNumberCheck(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean squareNumberCheck(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}
