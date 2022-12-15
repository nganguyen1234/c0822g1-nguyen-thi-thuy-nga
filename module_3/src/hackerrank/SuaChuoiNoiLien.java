package hackerrank;

public class SuaChuoiNoiLien {
    public static void main(String[] args) {
        System.out.println(insertSpace("DaNang"));
    }
    public static String insertSpace(String s) {
        String upperCaseRegex = "[A-Z]";
        String lowerCaseRegex = "[a-z]";
        String str = "";
        String[] strings = s.split("");
        for(int i = 0; i < strings.length; i++){
            if(strings[i].matches(upperCaseRegex)){
                String word = strings[i];
                for(int j = i+1;j<strings.length;j++){
                    if(strings[j].matches(lowerCaseRegex)){
                        word += strings[j];}else{
                        break;
                    }
                }
                str += word;
                str += " ";
            }
        }
        return str.toLowerCase();
        // Write your code here

    }
}
