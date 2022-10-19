package ss11_dsa_stack_queue.exercise.exercise1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class ArrayReverse {
    Scanner scanner = new Scanner(System.in);

    public void reverseIntegers() {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Nhập vào số lượng phần tử của mảng:");
        int n = Integer.parseInt(scanner.nextLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập vào phần tử thứ " + (i + 1));
            ints[i] = Integer.parseInt(scanner.nextLine());
            stack.push(ints[i]);
        }
        for (int i = 0; i < n; i++) {
            ints[i] = stack.pop();
        }
        System.out.println("Mảng sau khi đảo ngược là:");
        System.out.println(Arrays.toString(ints));
    }

    public void reverseString() {
        Stack<String> wStack = new Stack<>();
        System.out.println("Nhập vào một chuối:");
        String string = scanner.nextLine();
        String[] array = string.split("");
        for (String item : array) {
            wStack.push(item);
        }
        string = "";
        for (int i = 0; i < array.length; i++) {
            array[i] = wStack.pop();
            string += "" + array[i];
        }
        System.out.println("Chuỗi sau khi được đảo ngược là: ");
        System.out.println(string);
    }
}
