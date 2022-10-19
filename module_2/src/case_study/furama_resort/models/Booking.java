package case_study.furama_resort.models;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Person.Customer;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Date startDate;
    private Date endDate;
    private Facility serviceName;
    private Customer customerId;

    public Booking(){
    }

    public Booking(int bookingId, Date startDate, Date endDate, Facility serviceName, Customer customerId) {
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

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
}
