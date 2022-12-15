package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChuyenSoLaMaQuaSTN {
    public static void main(String[] args) {
        System.out.println(sovle("MCMXCIV"));
    }

    public static int sovle(String s) {
        String[] str = s.split("");
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(str));
        int result = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("I")) {
                if (list.get(i+1).equals("V")) {
                    result += 4;
                    list.remove(i);
                    i--;
                    list.remove(i + 1);
                }
            }

            if (list.get(i).equals("I")) {
                if (list.get(i+1).equals("X")) {
                    result += 9;
                    list.remove(i);
                    i--;
                    list.remove(i + 1);

                }
            }

            if (list.get(i).equals("X")) {
                if (list.get(i+1).equals("L")) {
                    result += 40;
                    list.remove(i);
                    i--;
                    list.remove(i + 1);

                }
            }
            if (list.get(i).equals("X")) {
                if (list.get(i+1).equals("C")) {
                    result += 90;
                    list.remove(i);
                    i--;
                    list.remove(i + 1);

                }
            }

            if (list.get(i).equals("C")) {
                if (list.get(i+1).equals("D")) {
                    result += 400;
                    list.remove(i);
                    i--;
                    list.remove(i + 1);

                }
            }
            if (list.get(i).equals("C")) {
                if (list.get(i+1).equals("M")) {
                    result += 900;
                    list.remove(i);
                    i--;
                    list.remove(i + 1);

                }
            }

        }
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case "I":
                    result += 1;
                    break;
                case "V":
                    result += 5;
                    break;
                case "X":
                    result += 10;
                    break;
                case "L":
                    result += 50;
                    break;
                case "C":
                    result += 100;
                    break;
                case "D":
                    result += 500;
                    break;
                case "M":
                    result += 1000;
                    break;
            }
        }
        return result;
        // Write your code here

    }
}
