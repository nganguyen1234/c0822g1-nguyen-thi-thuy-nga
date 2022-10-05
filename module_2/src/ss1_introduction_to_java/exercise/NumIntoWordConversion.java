package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class NumIntoWordConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        String hundreds = null;
        String tens = null;
        String units = null;
        int temp = 0;
        if (number < 1000 && number > 99) {
            switch (number / 100) {
                case 1:
                    hundreds = "one hundred";
                    break;
                case 2:
                    hundreds = "two hundred";
                    break;
                case 3:
                    hundreds = "three hundred";
                    break;
                case 4:
                    hundreds = "four hundred";
                    break;
                case 5:
                    hundreds = "five hundred";
                    break;
                case 6:
                    hundreds = "six hundred";
                    break;
                case 7:
                    hundreds = "seven hundred";
                    break;
                case 8:
                    hundreds = "eight hundred";
                    break;
                case 9:
                    hundreds = "nine hundred";
                    break;
            }
            temp = number;
            number %= 100;
            System.out.print(hundreds + " ");
        }
        if (number < 100 && number > 9) {
            switch (number / 10) {
                case 1:
                    switch (number) {
                        case 10:
                            tens = "ten";
                            break;
                        case 11:
                            tens = "eleven";
                            break;
                        case 12:
                            tens = "twelve";
                            break;
                        case 13:
                            tens = "thirteen";
                            break;
                        case 14:
                            tens = "fourteen";
                            break;
                        case 15:
                            tens = "fifteen";
                            break;
                        case 16:
                            tens = "sixteen";
                            break;
                        case 17:
                            tens = "seventeen";
                            break;
                        case 18:
                            tens = "eighteen";
                            break;
                        case 19:
                            tens = "nineteen";
                            break;
                    }
                    break;
                case 2:
                    tens = "twenty";
                    break;
                case 3:
                    tens = "thirty";
                    break;
                case 4:
                    tens = "forty";
                    break;
                case 5:
                    tens = "fifty";
                    break;
                case 6:
                    tens = "sixty";
                    break;
                case 7:
                    tens = "seventy";
                    break;
                case 8:
                    tens = "eighty";
                    break;
                case 9:
                    tens = "ninety";
                    break;

            }
            temp = number;
            number %= 10;
            System.out.print(tens + " ");
        }
        if (number < 10) {
            if ((temp % 100 != 0) && temp % 10 != 0 && temp > 20 || temp == 0) {
                switch (number) {
                    case 0:
                        units = "zero";
                        break;
                    case 1:
                        units = "one";
                        break;
                    case 2:
                        units = "two";
                        break;
                    case 3:
                        units = "three";
                        break;
                    case 4:
                        units = "four";
                        break;
                    case 5:
                        units = "five";
                        break;
                    case 6:
                        units = "six";
                        break;
                    case 7:
                        units = "seven";
                        break;
                    case 8:
                        units = "eight";
                        break;
                    case 9:
                        units = "nine";
                        break;
                }

            }
            if (units != null) {
                System.out.print(units + " ");
            }

        }

    }
}