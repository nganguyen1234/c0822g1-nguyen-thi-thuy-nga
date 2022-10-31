package case_study.furama_resort.models;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Person.Customer;

import java.util.Comparator;
import java.util.Date;

public class Booking implements Comparator<Booking> {
    private int bookingId;
    private Date startDate;
    private Date endDate;
    private Facility serviceName;
    private int customerId;

    public Booking() {
    }

    public Booking(int bookingId, Date startDate, Date endDate, Facility serviceName, int customerId) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.serviceName = serviceName;
        this.customerId = customerId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Facility getServiceName() {
        return serviceName;
    }

    public void setServiceName(Facility serviceName) {
        this.serviceName = serviceName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getStartDate() == o2.getStartDate()) {
            return o1.getEndDate().compareTo(o2.getEndDate());
        }
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
