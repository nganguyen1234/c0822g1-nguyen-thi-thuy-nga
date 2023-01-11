package giai_thuat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IsoscelesTriangle {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String d = "2022-01-11";
        try {
            LocalDate startDate = LocalDate.parse(, formatter);
            String[] s = addContractDto.startDate.split("-");
            String newDate = s[1] + "/" + s[2] + "/" + s[0];
            LocalDate.parse(newDate, formatter1);
            addContractDto.setStartDate(newDate);
        } catch (DateTimeParseException e) {
            errors.rejectValue("startDate", "startDate", "Ngày bắt đầu yêu cầu đúng định dạng dd/MM/yyyy");
        }
    }


}
