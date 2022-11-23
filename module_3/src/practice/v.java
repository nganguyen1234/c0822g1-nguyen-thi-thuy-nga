package practice;

import java.util.Scanner;

//Viết chương trình cho phép nhập vào số nguyên n( n <= 20 ), in ra số Fibonacci ứng với nó.
//        Số Fibonacci là số mà nó bằng tổng của 2 số Fibonacci trước nó.
//        Với giả thuyết là Fi(0) = 1, Fi(1) = 1.
//        Ta có ví dụ: Fi(2) = Fi(0) + Fi(1) = 1+1 = 2, Fi(3) =Fi(2) + Fi(1) = 2+1 = 3, Fi(4) = Fi(3) + Fi(2) = 3+2 = 5, … Giả sử n = 4, đầu ra sẽ là 5.
public class v {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập n");
        int n;
        do {
            n = Integer.parseInt(scanner.nextLine());
        } while (n > 20);

        int count = 1;
        int so1 = 1;
        int so2 = 1;
        int sofibo = 0;
        if (n == 0 || n ==1) {
            System.out.println("1");
        } else {
            while (n > count) {
                sofibo = so1 + so2;
                so1 = so2;
                so2 = sofibo;
                count++;
            }
            System.out.println(sofibo);
        }
    }
}
