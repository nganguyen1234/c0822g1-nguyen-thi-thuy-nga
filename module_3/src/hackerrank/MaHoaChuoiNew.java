package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MaHoaChuoiNew {
    public static void main(String[] args) {

    }

    public static String solve(String planText) {
        if (planText.length() > 50 || planText.length() == 0) {
            return null;
        }
        String stringRegex = "[a-zA-Z]";//@bb1
        String[] str = planText.toLowerCase().split("");
        List<String> list = new ArrayList<>();
        int count;
        for (int i = 0; i < str.length; i += count) {
            count = 1;
            if (str[i].matches(stringRegex)) {
                for (int j = i + 1; j < str.length; j++) {
                    if (str[i].equals(str[j])) {
                        count++;
                    } else {
                        break;
                    }
                }

                list.add(str[i]);
                if (count >= 10 & count <= 15) {
                    switch (list.get(i)) {
                        case "10":
                            list.add("a");
                            break;
                        case "11":
                            list.add("b");
                            break;
                        case "12":
                            list.add("c");
                            break;
                        case "13":
                            list.add("d");
                            break;
                        case "14":
                            list.add("e");
                            break;
                        case "15":
                            list.add("f");
                            break;
                    }
                } else {
                    list.add(String.valueOf(count));
                    continue;
                }
            }
        }

                String rs = "";
                for (int i = list.size() - 1; i >= 0; i--) {
                    rs += list.get(i);
                }
                return rs;
            }
        }
