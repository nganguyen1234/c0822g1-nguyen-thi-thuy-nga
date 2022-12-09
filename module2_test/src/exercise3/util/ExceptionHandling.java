package exercise3.util;

import java.util.Scanner;

public class ExceptionHandling {
    public int enterPositiveNumber(){
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                int number =Integer.parseInt(scanner.nextLine());
                if (number>0){
                    return number;
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập vào một số nguyên dương");
            }



        }while (true);
    }

    public static void main(String[] args) {
        String name = "(84)+911234567";
        System.out.println(name.matches("(090\\d{7})|(091\\d{7})|(\\(84\\)\\+90\\d{7})|(\\(84\\)\\+91\\d{7})"));
    }
}
