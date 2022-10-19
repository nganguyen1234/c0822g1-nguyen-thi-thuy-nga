package giai_thuat.exercise1;

public class Rhombus {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j == 6 - i || j == i + 5) {
                    System.out.print(i);
                } else if (i >= 6 && (j == i - 4 || j == 15 - i)) {
                    System.out.print(10 - i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
