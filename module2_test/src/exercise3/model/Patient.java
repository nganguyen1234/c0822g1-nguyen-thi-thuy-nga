package exercise3.model;
/*
Tính kế thừa
 */
public class Patient extends Person {
    /*
    Tính bao đóng
     */
    private String dateOfBirth;
    private String vipDate;
/*
Tính đa hình
 */
    public Patient() {
    }

    public Patient(String id, String name, String gender, String dateOfBirth, String vipDate) {
        super(id, name, gender);
        this.dateOfBirth = dateOfBirth;
        this.vipDate = vipDate;
    }

   /*
   Tính bao đóng
    */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVipDate() {
        return vipDate;
    }

    public void setVipDate(String vipDate) {
        this.vipDate = vipDate;
    }
/*
Tính đa hình
 */
    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public String toString() {
        return "Patient{ " + super.toString() +
                " dateOfBirth='" + dateOfBirth + '\'' +
                ", vipDate='" + vipDate + '\'' +
                "} ";
    }
}
