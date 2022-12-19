package hackerrank;

public class DauNgoacDon {
    public static void main(String[] args) {
        System.out.println(solve("(){"));
    }
    public static String solve(String s) {
        // Write your code here
        String[] str = s.split("");
        for(int i = 0; i < str.length; i++){
            if(i%2==0){
                if (str[i].equals("}") ||str[i].equals(")")||str[i].equals("]")){
                    return "False";
                }
            }
            if (i==str.length-1 &&(str[i].equals("{") ||str[i].equals("(")||str[i].equals("["))){
                return "False";
            }
            if(str[i].equals("{") && !str[i+1].equals("}")){
                return "False";
            }
            if(str[i].equals("(") && !str[i+1].equals(")")){
                return "False";
            }
            if(str[i].equals("[") && !str[i+1].equals("]")){
                return "False";
            }
        }
        return "True";
    }

}
