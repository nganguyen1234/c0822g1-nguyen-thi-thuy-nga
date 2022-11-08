package case_study.furama_resort.models.Person;

public class EducationLevel {
    private String educationLevel;

    public EducationLevel() {
    }

    ;

    public EducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String convertLine() {
        return this.educationLevel;
    }

    @Override
    public String toString() {
        return educationLevel;
    }
}
