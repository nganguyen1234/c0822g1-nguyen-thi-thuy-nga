package case_study.furama_resort.common;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegexCheck {
    private Scanner scanner = new Scanner(System.in);

    public String enterVillaInfo() {
        String string;
        String villaRegex = "SVVL-\\d{4}";
        do {
            string = scanner.nextLine();
            if (string.matches(villaRegex)) {
                return string;
            } else {
                System.out.println("Try again!!!");
            }
        } while (true);
    }

    public String enterRoomInfo() {
        String string;
        String roomRegex = "SVRO-\\d{4}";
        do {
            string = scanner.nextLine();
            if (string.matches(roomRegex)) {
                return string;
            } else {
                System.out.println("Try again!!!");
            }
        } while (true);
    }

    public String enterServiceInfo() {
        String string;
        String serviceRegex = "[A-Z][a-z0-9]*";
        do {
            string = scanner.nextLine();
            if (string.matches(serviceRegex)) {
                return string;
            } else {
                System.out.println("Try again!!!");
            }
        } while (true);
    }
    public String enterDate(){
        String date;
        String dateRegex= "\\d{2}/\\d{2}/\\d{4}";
        do {
            try {
                date = scanner.nextLine();
                if (date.matches(dateRegex)){
                    return date;
                } throw new IllegalDateException("Try again");
//                if (number > 0 && number < 20) {
//                    return number;
//                }
            } catch (IllegalDateException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
