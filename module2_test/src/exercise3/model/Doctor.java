package exercise3.model;

/*
Tính kế thừa
 */
public class Doctor extends Person {
    /*
    Tính bao đóng
     */
    private int experienceYear;

    public Doctor() {
    }

    public Doctor(String id, String name, String gender, int experienceYear) {
        super(id, name, gender);
        this.experienceYear = experienceYear;
    }

    /*
    Tính bao đóng
     */
    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
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
        return "Doctor{" + super.toString() +
                " year=" + experienceYear +
                "} ";
    }
}
