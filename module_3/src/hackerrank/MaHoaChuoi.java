package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MaHoaChuoi {
    public static void main(String[] args) {
        System.out.println(solve("aaaaaaaaaaa"));
    }

    public static String solve(String planText) {
        if (planText.length()>50|| planText.length()==0){
            return null;
        }
        String stringRegex = "[a-zA-Z]";//@bb1
        String[] str = planText.toLowerCase().split("");
        List<String> list = new ArrayList<>();
        int count;
        for (int i = 0; i < str.length; i+=count) {
            count=1;
            if (str[i].matches(stringRegex)){
                for (int j = i + 1; j < str.length; j++) {
                    if (str[i].equals(str[j])) {
                        count++;
                    } else {
                        break;
                    }
                }

                list.add(str[i]);
                list.add(String.valueOf(count));
            }
        }
        String[] s = new String[list.size()];
        for (int i = 0; i < s.length; i++) {
            if (!list.get(i).matches(stringRegex)){
                if (Integer.parseInt(list.get(i)) >= 10 & Integer.parseInt(list.get(i)) <= 15) {
                    switch (list.get(i)) {
                        case "10":
                            s[i] = "a";
                            break;
                        case "11":
                            s[i] = "b";
                            break;
                        case "12":
                            s[i] = "c";
                            break;
                        case "13":
                            s[i] = "d";
                            break;
                        case "14":
                            s[i] = "e";
                            break;
                        case "15":
                            s[i] = "f";
                            break;
                    }
                }  else {
                    s[i] = list.get(i);
                    continue;
                }
            }
            else {
                s[i] = list.get(i);
            }
        }
        String rs = "";
        for (int i = s.length - 1; i >= 0; i--) {
            rs += s[i];
        }
        return rs;
    }
}
