package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SoXaSoXNhat {
    public static void main(String[] args) {
        System.out.println(findNumber("22343534.12 42312312.13 7235345.154 0 -5", (float) 15.5));
    }

    public static float findNumber(String s, float x) {
        String[] str = s.split(" ");
        Float[] floats = new Float[str.length];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = Float.parseFloat(str[i]);
        }
        float max = Math.abs(x - floats[0]);
        float result = 0;
        for (Float f : floats) {
            Float diff = Math.abs(f - x);
            if (max < diff) {
                max = diff;
                result = f;
            }
        }
        return result;
    }
//    public static float findNumber(String s, float x) {
//        Map<Float,Integer> map = new HashMap<>();
//        String[] str = s.split(" ");
//        for(int i = 0; i < str.length; i++){
//            map.put(Math.abs(Float.parseFloat(str[i])-x),i);
//        }
//        float max =Math.abs(Float.parseFloat(str[0])-x) ;
//        int index =0;
//        for(Float key:map.keySet()){
//            if(max < key){
//                max = key;
//                index = map.get(max);
//            }
//        }
//        return Float.parseFloat(str[index]+"f");
//
//    }
}
