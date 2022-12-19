package hackerrank;

public class VongDeoTay {
    public static void main(String[] args) {
        System.out.println(getMinString("ZACAB"));
    }
    public static String getMinString(String bracelet) {
        // Write your code here
        int min = bracelet.charAt(0);
        int index = 0;
        for (int i = 0; i < bracelet.length() ; i++) {
            if (min>=bracelet.charAt(i)){
                min = bracelet.charAt(i);
                index = i;
            }
        }
        String result = "";
        String[] str = bracelet.split("");
        for (int i = index; i < str.length ; i++) {
            result += str[i];
        }
        for (int i = 0; i < index ; i++) {
            result += str[i];
        }
        return result;
    }
}
