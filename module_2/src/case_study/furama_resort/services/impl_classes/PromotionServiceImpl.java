package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.services.BookingService;
import case_study.furama_resort.services.PromotionService;

public class PromotionServiceImpl implements PromotionService {

    public void displayCustomerInAYear(int year) {
        BookingService bookingService = new BookingServiceImpl();
        bookingService.displayCustomerList(year);
    }

}
