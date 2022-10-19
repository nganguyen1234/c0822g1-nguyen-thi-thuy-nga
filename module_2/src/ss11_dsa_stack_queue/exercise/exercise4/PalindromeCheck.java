package ss11_dsa_stack_queue.exercise.exercise4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {
    public boolean check() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiếm tra:");
        String string = scanner.nextLine().toUpperCase();
        String[] array = string.split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
            queue.add(array[i]);
        }
        for (int i = 0; i < stack.size(); i++) {
            if (!(stack.pop()).equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }
}
