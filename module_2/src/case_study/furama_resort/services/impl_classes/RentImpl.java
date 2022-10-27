package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Facility.RentalType;

public class RentImpl {
    public static RentalType[] types = new RentalType[3];

    static {
        types[0] = new RentalType("daily");
        types[1] = new RentalType("monthly");
        types[2] = new RentalType("yearly");
    }

    public static void displayType() {
        int i = 1;
        for (RentalType type : types) {
            System.out.println(i++ + " " + type);
        }
    }
}
