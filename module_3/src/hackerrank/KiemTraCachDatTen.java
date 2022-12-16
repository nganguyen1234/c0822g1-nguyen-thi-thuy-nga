package hackerrank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KiemTraCachDatTen {
    public static void main(String[] args) {
//        System.out.println(checkConvention("Hello","class"));
        List<String[]> stringList = new ArrayList<>();
        stringList.add(new String[]{"a", "b", "c"});
        String[] str = new String[3];

        System.out.println(Arrays.toString(stringList.get(0)));
    }
    public static boolean checkConvention(String name, String typeFile) {
        // Write your code here
        String classRegex = "([A-Z][a-z]+)+";
        String methodRegex ="[a-z][a-zA-Z]+";
        String packageRegex = "([a-z]+|([a-z]+_[a-z]+))";
        switch(typeFile){
            case "package":
                if(name.matches(packageRegex)){
                    return true;
                }
                break;
            case "class":
                if(name.matches(classRegex)){
                    return true;
                }
                break;
            case "field":
            case "method":
                if(name.matches(methodRegex)){
                    return true;
                }
        }
        return false;
    }
}
