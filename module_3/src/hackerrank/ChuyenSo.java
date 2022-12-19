package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ChuyenSo {
    public static void main(String[] args) {
        System.out.println(solve(234));
    }

//    public static String solve(int n) {
//        String[] str = String.valueOf(n).split("");
//        List<String[]> stringList = new ArrayList<>();
//        int quantity = 1;
//        for (int i = 0; i < str.length; i++) {
//            switch (str[i]) {
//                case "2":
//                    stringList.add(new String[]{"a", "b", "c"});
//                    quantity *= 3;
//                    break;
//                case "3":
//                    stringList.add(new String[]{"d", "e", "f"});
//                    quantity *= 3;
//                    break;
//                case "4":
//                    stringList.add(new String[]{"g", "h", "i"});
//                    quantity *= 3;
//                    break;
//                case "5":
//                    stringList.add(new String[]{"j", "k", "l"});
//                    quantity *= 3;
//                    break;
//                case "6":
//                    stringList.add(new String[]{"m", "n", "o"});
//                    quantity *= 3;
//                    break;
//                case "7":
//                    stringList.add(new String[]{"p", "q", "r", "s"});
//                    quantity *= 4;
//                    break;
//                case "8":
//                    stringList.add(new String[]{"t", "u", "v"});
//                    quantity *= 3;
//                    break;
//                case "9":
//                    stringList.add(new String[]{"w", "x", "y", "z"});
//                    quantity *= 4;
//                    break;
//            }
//        }
//        String result = "";
//        if(stringList.size() == 0){
//            return "";
//        }
//        if (stringList.size() == 1) {
//            for (String a : stringList.get(0)) {
//                result += a + " ";
//            }
//        } else {
//            for (int i = 0; i < stringList.size(); i++) {
//                for (int j = i + 1; j < stringList.size(); j++) {
//                    for (int k = 0; k < stringList.get(i).length; k++) {
//                        for (int l = 0; l < stringList.get(j).length; l++) {
//                            result += stringList.get(i)[k] + stringList.get(j)[l] + " ";
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
    // Write your code here

    public static String solve(int n) {
        String[] str = String.valueOf(n).split("");
        List<String[]> stringList = new ArrayList<>();
        int quantity = 1;
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "2":
                    stringList.add(new String[]{"a", "b", "c"});
                    quantity *= 3;
                    break;
                case "3":
                    stringList.add(new String[]{"d", "e", "f"});
                    quantity *= 3;
                    break;
                case "4":
                    stringList.add(new String[]{"g", "h", "i"});
                    quantity *= 3;
                    break;
                case "5":
                    stringList.add(new String[]{"j", "k", "l"});
                    quantity *= 3;
                    break;
                case "6":
                    stringList.add(new String[]{"m", "n", "o"});
                    quantity *= 3;
                    break;
                case "7":
                    stringList.add(new String[]{"p", "q", "r", "s"});
                    quantity *= 4;
                    break;
                case "8":
                    stringList.add(new String[]{"t", "u", "v"});
                    quantity *= 3;
                    break;
                case "9":
                    stringList.add(new String[]{"w", "x", "y", "z"});
                    quantity *= 4;
                    break;
            }
        }
        String result = "";
        if (str.length == 0){
            return null;
        } else if (str.length == 1) {
            for (int i = 0; i < quantity; i++) {
                result += stringList.get(0)[i];
                if (i<quantity){
                    result += " ";
                }
            }
        } else if (str.length == 2) {
                    for (int k = 0; k < stringList.get(0).length; k++) {
                        for (int l = 0; l < stringList.get(1).length; l++) {
                            result += stringList.get(0)[k] + stringList.get(1)[l];
                            if ((k+1)*(l+1)<quantity){
                                result += " ";
                            }
                        }
                    }

        } else if (str.length == 3) {
                    for (int k = 0; k < stringList.get(0).length; k++) {
                        for (int l = 0; l < stringList.get(1).length; l++) {
                            for (int m = 0; m < stringList.get(2).length; m++) {
                                result += stringList.get(0)[k] + stringList.get(1)[l] + stringList.get(2)[m];
                                if ((k+1)*(l+1)*(m+1)<quantity){
                                    result += " ";
                                }
                            }
                        }
                    }


        } else {
                    for (int k = 0; k < stringList.get(0).length; k++) {
                        for (int l = 0; l < stringList.get(1).length; l++) {
                            for (int m = 0; m < stringList.get(2).length; m++) {
                                for (int o = 0; o < stringList.get(3).length; o++) {
                                    result += stringList.get(0)[k] + stringList.get(1)[l] + stringList.get(2)[m] + stringList.get(3)[o];
                                    if ((k+1)*(l+1)*(m+1)*(o+1)<quantity){
                                        result += " ";
                                    }
                                }
                            }
                        }
                    }
                }

        return result;
        // Write your code here

    }
}
