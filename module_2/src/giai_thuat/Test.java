package giai_thuat;

public class Test {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        String[] array = s.split("");
        int sum = 0;
        for(int i = 0; i < array.length;i++){
            switch(array[i]){
                case "I":
                    sum += 1;
                    if( (i< array.length-1 ) && (array[i+1]=="V" || array[i+1]=="X") ){
                        sum -= 2;}
                    break;
                case "V":
                    sum += 5;
                    break;
                case "X":
                    sum += 10;
                    if((i< array.length-1 ) && (array[i+1] == "L" || array[i+1].equals("C"))){
                        sum -= 20;
                    }
                    break;
                case "L":
                    sum += 50;
                    break;
                case "C":
                    sum += 100;
                    if((i< array.length-1 ) && (array[i+1]=="D" || array[i+1] == "M")){
                        sum -= 200;
                    }
                    break;
                case "D":
                    sum += 500;
                    break;
                case "M":
                    sum += 1000;
                    break;
            }

        }
        return sum;

    }
}
