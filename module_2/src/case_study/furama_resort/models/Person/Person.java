package case_study.furama_resort.models.Person;

public abstract class Person {
    private String name;
    private int dateOfBirth;
    private String gender;
    private int phoneNumber;
    private int citizenIdentityNumber;
    private String email;

    public Person(String name, int dateOfBirth, String gender, int phoneNumber, int citizenIdentityNumber, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.citizenIdentityNumber = citizenIdentityNumber;
        this.email = email;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCitizenIdentityNumber() {
        return citizenIdentityNumber;
    }

    public void setCitizenIdentityNumber(int citizenIdentityNumber) {
        this.citizenIdentityNumber = citizenIdentityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String convertLine() {
        String comma = ",";
        return this.name + comma + this.dateOfBirth + comma + this.gender + comma + this.phoneNumber + comma + this.citizenIdentityNumber;
    }

    @Override
    public String toString() {
        return "name:'" + name + '\'' +
                ", date of birth:" + dateOfBirth +
                ", gender:'" + gender + '\'' +
                ", phone number:" + phoneNumber +
                ", citizen identity number:" + citizenIdentityNumber +
                ", email:'" + email;
    }
}
