package case_study.furama_resort.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ExceptionHandling {
    private final Scanner scanner = new Scanner(System.in);

    public int enterPositiveInteger() {
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number;
                }
                System.out.println("Please enter a positive integer");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public double enterDouble() {
        double number;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number > 0) {
                    return number;
                }
                System.out.println("Try again!!!");

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public double enterArea() {
        double area;
        do {
            try {
                area = Double.parseDouble(scanner.nextLine());
                if (area > 30) {
                    return area;
                }
                System.out.println("Try again!!!");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public int enterNumberOfPeople() {
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number < 20) {
                    return number;
                }
                System.out.println("Try again!!!");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


// public boolean isValidDate(String date, DateTimeFormatter dateTimeFormatter) {
//        try {
//            LocalDate.parse(date, dateTimeFormatter);
//        } catch (DateTimeParseException e) {
//            return false;
//        }
//        return true;
//    }

    //  public LocalDate isValidDate(String date, DateTimeFormatter dateTimeFormatter) {
//        LocalDate date1;
//       do {
//           try {
//             date1 =  LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
//
//           } catch (DateTimeParseException e) {
//               System.out.println(e.getMessage());
//           }
//
//       }while (true);
//
//    }
    public String enterDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1;
        do {
            try {
                date1 = LocalDate.parse(scanner.nextLine(), formatter);
                return date1.format(formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Try again");
            }
        } while (true);
    }

    public String enterEndDate(String startDate) {
        RegexCheck regexCheck = new RegexCheck();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String endDate;
        Date endDate1;
        Date startDate1;
        do {
            try {
                endDate = enterDate();
                endDate1 = simpleDateFormat.parse(endDate);
                startDate1 = simpleDateFormat.parse(startDate);
                if ((endDate1.getTime() - startDate1.getTime()) > 0) {
                    return endDate;
                }
                throw new IllegalDateException("Try again");

            } catch (IllegalDateException | ParseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


    //    public String enterDateOfBirth() {
//        RegexCheck regexCheck = new RegexCheck();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String dateOfBirth;
//        Date dateOfBirth1;
//        long currentDate;
//        long duration =  TimeUnit.DAYS.toMillis(18 * 365);
//        long duration2 = TimeUnit.DAYS.toMillis(100 * 365);
//        do {
//            try {
//                dateOfBirth = enterDate();
//                dateOfBirth1 = simpleDateFormat.parse(dateOfBirth);
//                currentDate = System.currentTimeMillis();
//                if (currentDate - dateOfBirth1.getTime() > duration && currentDate - dateOfBirth1.getTime() < duration2) {
//                    return dateOfBirth;
//                }
//                throw new IllegalDateException("Try again");
//
//            } catch (IllegalDateException | ParseException | DateTimeParseException e) {
//                System.out.println(e.getMessage());
//            }
//        } while (true);
//    }
    public String enterDateOfBirth() {
        String dateOfBirth;
        LocalDate dateOfBirth1;
        long age;
        do {
            try {
                dateOfBirth = enterDate();
                dateOfBirth1 = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                age = ChronoUnit.YEARS.between(dateOfBirth1, LocalDate.now());
                if (age < 100 && age >= 18) {
                    return dateOfBirth;
                }
                throw new IllegalDateException("Try again");

            } catch (IllegalDateException | DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
