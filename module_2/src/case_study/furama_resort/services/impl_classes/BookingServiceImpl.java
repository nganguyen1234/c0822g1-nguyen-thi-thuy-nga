package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Booking;

import java.util.SortedSet;
import java.util.TreeSet;

public class BookingServiceImpl {
    SortedSet<Booking> bookingList = new TreeSet<>();
    public void addBooking(Booking booking){
        bookingList.add(booking);
    }
public void displayBooking(){
        bookingList.forEach(booking -> {
            System.out.println(booking);
        });
}


}
