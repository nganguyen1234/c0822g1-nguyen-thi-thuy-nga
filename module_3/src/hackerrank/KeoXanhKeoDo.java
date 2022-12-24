package hackerrank;

public class KeoXanhKeoDo {
    public static void main(String[] args) {

    }
    public static String solve(int r, int b, int d) {
        // Write your code here
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= b ; j++) {
                if (Math.abs(j-i)<=d){
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
