package case_study.furama_resort.models;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.services.BookingComparator;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Booking {
    private int bookingId;
    private String startDate;
    private String endDate;
    private String serviceName;
    private int customerId;

    public Booking() {
    }

    public Booking(int bookingId, String startDate, String endDate, String serviceName, int customerId) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", serviceName=" + serviceName +
                ", customerId=" + customerId +
                '}';
    }

    public String convertLine() {
        String comma = ",";
        return this.bookingId + comma + this.startDate + comma + this.endDate + comma + this.serviceName + comma + this.customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return this.bookingId == booking.getBookingId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bookingId, this.startDate, this.endDate);
    }
}
