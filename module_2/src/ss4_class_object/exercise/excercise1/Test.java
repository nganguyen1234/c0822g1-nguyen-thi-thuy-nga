package ss4_class_object.exercise.excercise1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        System.out.println("Quadratic Equation Resolver");
        System.out.println("Given a equation as 'ax^2 + bx + c = 0', please enter constants: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        a = Double.parseDouble(scanner.nextLine());
        System.out.println("b: ");
        b = Double.parseDouble(scanner.nextLine());
        System.out.println("c: ");
        c = Double.parseDouble(scanner.nextLine());
        QuadraticEquation equation1 = new QuadraticEquation(a, b, c);
        if (equation1.getA() == 0) {
            if (equation1.getB() == 0) {
                if (equation1.getC() == 0) {
                    System.out.println("The solution is all x");
                } else {
                    System.out.println("No solution");
                }
            } else {
                double answer = -equation1.getC() / equation1.getB();
                System.out.println("The equation has one root" + answer);
            }
        } else {
            double delta = equation1.getDiscriminant();
            if (delta >= 0) {
                double root1 = equation1.getRoot1();
                double root2 = equation1.getRoot2();
                if (delta > 0) {
                    System.out.println("The equation has two roots " + root1 + " and " + root2);
                } else {
                    System.out.println(" " + root1);
                }
            } else {
                System.out.println("The equation has no real roots");
            }
        }
    }
}
