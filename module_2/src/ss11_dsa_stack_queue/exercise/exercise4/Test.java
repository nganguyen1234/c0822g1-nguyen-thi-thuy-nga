package ss11_dsa_stack_queue.exercise.exercise4;

public class Test {
    public static void main(String[] args) {
        PalindromeCheck palindromeCheck = new PalindromeCheck();
        if (palindromeCheck.check()){
            System.out.println("Đây là chuỗi Palindrome ");
        } else {
            System.out.println("Đây không phải là chuỗi Palindrome ");
        }
    }
}
