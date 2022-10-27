package case_study.furama_resort.models.Person;

public class Employee extends Person {
    private int employeeId;
    private String position;
    private double salary;
    private EducationLevel educationLevel;

    public Employee() {
    }

    public Employee(String name, int dateOfBirth, String gender, int phoneNumber, int cmnd, String email, int employeeId, String position, double salary, EducationLevel educationLevel) {
        super(name, dateOfBirth, gender, phoneNumber, cmnd, email);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.educationLevel = educationLevel;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Override
    public String toString() {
        return "name: " + getName() + "\tdate of birth: " + getDateOfBirth() + "\tgender: " + getGender() + "\tphone number: " + getPhoneNumber() + "\tid:" + getEmployeeId() + "\tcmnd: " + getCmnd() + "\temail: " + getEmail() + "\tposition: " + getPosition() + "\tsalary: " + getSalary() + "\teducation level: " + getEducationLevel();
    }
}
