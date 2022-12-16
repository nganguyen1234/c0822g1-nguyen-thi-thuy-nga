package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ChuyenSo {
    public static void main(String[] args) {
        System.out.println(solve(2345));
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
        for(int i = 0; i < str.length; i++){
            switch(str[i]){
                case "2":
                    stringList.add(new String[]{"a", "b", "c"});
                    quantity *=3;
                    break;
                case "3":
                    stringList.add(new String[]{"d", "e", "f"});
                    quantity *=3;
                    break;
                case "4":
                    stringList.add(new String[]{"g", "h", "i"});
                    quantity *=3;
                    break;
                case "5":
                    stringList.add(new String[]{"j", "k", "l"});
                    quantity *=3;
                    break;
                case "6":
                    stringList.add(new String[]{"m", "n", "o"});
                    quantity *=3;
                    break;
                case "7":
                    stringList.add(new String[]{"p", "q", "r","s"});
                    quantity *=4;
                    break;
                case "8":
                    stringList.add(new String[]{"t", "u", "v"});
                    quantity *=3;
                    break;
                case "9":
                    stringList.add(new String[]{"w", "x", "y","z"});
                    quantity *=4;
                    break;
            }
        }
        String[] resultStr = new String[quantity];
        for(int i = 0; i < resultStr.length;i++){
            str[i] = "";
            for(int j = 0; j < stringList.size();j++){
                for(int k = 0; k < stringList.get(j).length;k++){
                    str[i]+= stringList.get(j)[k];
                    break;
                }
            }
        }
        String result = "";
        for(int i = 0; i < resultStr.length; i++){
            result += resultStr[i];
            if(i < resultStr.length-1){
                result += " ";
            }
        }
        return result;
        // Write your code here

    }
}
