package case_study.furama_resort.services;

import case_study.furama_resort.models.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDateO1 = LocalDate.parse(o1.getStartDate(), formatter);
        LocalDate startDateO2 = LocalDate.parse(o2.getStartDate(), formatter);
        if (startDateO1.equals(startDateO2)) {
            LocalDate endDateO1 = LocalDate.parse(o1.getEndDate(), formatter);
            LocalDate endDateO2 = LocalDate.parse(o2.getEndDate(), formatter);
            if (endDateO1.equals(endDateO2)) {
                return o1.getBookingId() - o2.getBookingId();
            }
            return endDateO1.compareTo(endDateO2);
        }

        return startDateO1.compareTo(startDateO2);
    }
}
