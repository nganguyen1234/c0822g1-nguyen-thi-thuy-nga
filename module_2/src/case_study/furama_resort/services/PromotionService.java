package case_study.furama_resort.services;

public interface PromotionService {
    void displayCustomerInAYear(int year);
    boolean displayPromotionList(int voucher10, int voucher20, int voucher50);
    void displayThisMonthCustomers();
}
