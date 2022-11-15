package giai_thuat.exercise3_check_so_fibonacci_snt;

public class NumberCheck {
    public boolean primeCheck(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean fibonacciCheck(int number) {
        int number1 = 0;
        int number2 = 1;
        int number3;
        do {
            if (number1 == number) {
                return true;
            }
            number3 = number1 + number2;
            number1 = number2;
            number2 = number3;
        } while (number1 <= number);

        return false;
    }

    public boolean squareNumberCheck(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}
