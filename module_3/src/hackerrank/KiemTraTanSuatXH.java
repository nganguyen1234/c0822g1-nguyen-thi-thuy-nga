package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KiemTraTanSuatXH {
    public static void main(String[] args) {
        System.out.println(checkCountElement("1 2 2 0 1 3 0 3"));
    }
    public static boolean checkCountElement(String s) {
        String[] strings = s.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length ; i++) {
            if (map.containsKey(strings[i])){
                map.put(strings[i],map.get(strings[i])+1);
            } else {
                map.put(strings[i],1);
            }

        }
        int count = map.get(strings[0]);
        for (String key:map.keySet()) {
            if (map.get(key)!= count){
                return false;
            }
        }
        return true;
    }
}
