package thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'ax + b = c', please enter constants: ");
        float a;
        float b;
        float c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        a = scanner.nextFloat();
        System.out.println("b: ");
        b = scanner.nextFloat();
        System.out.println("c: ");
        c = scanner.nextFloat();
        if (a == 0) {
            if (b == c) {
                System.out.println("The solution is all x");
            } else {
                System.out.println("No solution");
            }
        } else {
            float answer = (c - b) / a;
            System.out.println("phuong trinh co nghiem" + answer);
        }
    }
}
