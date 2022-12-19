package hackerrank;

public class MangDep {
    public static void main(String[] args) {
        System.out.println(perfectArray("1 3 4 2 2"));
    }

    public static boolean perfectArray(String s) {
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            int bSum = 0;
            int count1 = 0;
            int aSum = 0;
            int count2 =0;
            for (int j = 0; j < i; j++) {
                bSum += Integer.parseInt(strings[j]);
                count1++;
            }
            for (int j = i + 1; j < strings.length; j++) {
                aSum += Integer.parseInt(strings[j]);
                count2++;
            }
            if (bSum == aSum & count1 != 0 && count2!= 0) {
                return true;
            }

        }
        return false;
    }
}
