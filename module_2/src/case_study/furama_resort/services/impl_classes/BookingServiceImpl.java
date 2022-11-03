package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.services.BookingService;
import case_study.furama_resort.common.FileService;


import java.util.Calendar;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    private final FileService fileService = new FileService();
    private final String FILE_PATH = "src\\case_study\\furama_resort\\data\\booking.csv";
    private TreeSet<Booking> bookingSet = fileService.readBooking(FILE_PATH);

    public void readBooking() {
        bookingSet = fileService.readBooking(FILE_PATH);
    }

    public void writeBooking() {
        fileService.writeBooking(FILE_PATH, bookingSet);
    }

    public void addBooking(Booking booking) {
        readBooking();
        bookingSet.add(booking);
        writeBooking();
    }

    public void displayBooking() {
        readBooking();
        bookingSet.forEach(booking -> {
            System.out.println(booking.toString());
        });
    }

    public int countFacility(String name) {
        readBooking();
        int count = 0;
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int month;
        for (Booking booking : bookingSet) {
            month = Integer.parseInt(booking.getStartDate().split("/")[1]);
            if (booking.getServiceName().equals(name) && month == currentMonth) {
                count++;
            }
        }
        return count;
    }

}
