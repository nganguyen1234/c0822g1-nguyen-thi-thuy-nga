package hackerrank;

public class KyTuCuoi {
    public static void main(String[] args) {
        System.out.println(Math.pow(9,4));
    }
    public static long solve(long n, long m) {
        String a = String.valueOf(n);
        switch (a.charAt(a.length() - 1)) {
            case '2':
                if (m % 4 == 1) {
                    return 2;
                }
                if (m % 4 == 2) {
                    return 4;
                }
                if (m % 4 == 3) {
                    return 8;
                }
                if (m % 4 == 0) {
                    return 6;
                }
                break;
            case '3':
                if (m % 4 == 1) {
                    return 3;
                }
                if (m % 4 == 2) {
                    return 9;
                }
                if (m % 4 == 3) {
                    return 7;
                }
                if (m % 4 == 0) {
                    return 1;
                }
            case '4':
                if (m % 2 == 1) {
                    return 4;
                }
                if (m % 2 == 0) {
                    return 6;
                }
                break;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                if (m % 4 == 1) {
                    return 7;
                }
                if (m % 4 == 2) {
                    return 9;
                }
                if (m % 4 == 3) {
                    return 3;
                }
                if (m % 4 == 0) {
                    return 1;
                }
            case '8':
                if (m % 4 == 1) {
                    return 8;
                }
                if (m % 4 == 2) {
                    return 4;
                }
                if (m % 4 == 3) {
                    return 2;
                }
                if (m % 4 == 0) {
                    return 6;
                }
            case '9':
                if (m % 2 == 1) {
                    return 9;
                }
                if (m % 2 == 0) {
                    return 1;
                }
        }
        return 0;
    }
}
