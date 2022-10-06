package ss2_loop_array.practice;

import java.util.Scanner;

public class DrawingMenu {
    public static void main(String[] args) {

        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu:" + "\n" +
                    "1. Print the rectangle" + "\n" +
                    "2. Print the square triangle" + "\n" +
                    "3. Print isosceles triangle" + "\n" +
                    "4. Exit" + "\n" +
                    "Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    int height;
                    int width;
                    do {
                        System.out.println("Enter rectangle's height: ");
                        height = Integer.parseInt(scanner.nextLine());
                        if (height <= 0) {
                            System.out.println("Error!");
                        }
                    } while (height <= 0);
                    do {
                        System.out.println("Enter rectangle's width: ");
                        width = Integer.parseInt(scanner.nextLine());
                        if (width <= 0) {
                            System.out.println("Error!");
                        }
                    } while (width <= 0);

                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int side;
                    do {
                        System.out.println("Enter the side: ");
                        side = Integer.parseInt(scanner.nextLine());
                        if (side <= 0) {
                            System.out.println("Error!");
                        }
                    } while (side <= 0);

                    for (int i = 0; i < side; i++) {
                        for (int j = 0; j < side; j++) {
                            if (i >= j) {
                                System.out.print("*");
                            }
                        }
                        System.out.println(" ");
                    }
                    System.out.println();
                    for (int i = 0; i < side; i++) {
                        for (int j = 0; j < side; j++) {
                            if (j < side - i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < side; i++) {
                        for (int j = 0; j < side; j++) {
                            if (j >= side - 1 - i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < side; i++) {
                        for (int j = 0; j < side; j++) {
                            if (i > j) {
                                System.out.print(" ");
                            }
                            if (i <= j) {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    do {
                        System.out.println("Enter the side: ");
                        side = Integer.parseInt(scanner.nextLine());
                        if (side <= 0) {
                            System.out.println("Error!");
                        }
                    } while (side <= 0);
                    for (int i = 0; i <= side; i += 2) {
                        for (int j = 0; j <= side - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j <= i; j++) {
                            System.out.print(" *");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        } while (true);
    }
}
