package case_study.furama_resort.services;

import case_study.furama_resort.models.Booking;

public interface BookingService extends Service {
    void addBooking(Booking booking);
    void displayBooking();
    int countFacility(String name);

}
