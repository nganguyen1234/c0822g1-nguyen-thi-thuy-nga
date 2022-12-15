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
        String name = "123-12-1 ";
        System.out.println(name.matches("[\\dA-Z]{3}-[\\dA-Z]{2}-[\\dA-Z]{2}"));
    }
}
