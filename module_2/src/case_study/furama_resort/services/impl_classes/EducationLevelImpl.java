package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.EducationLevel;

public class EducationLevelImpl {
    public static EducationLevel[] educationLevels = new EducationLevel[4];

    static {
        educationLevels[0] = new EducationLevel("high school diploma");
        educationLevels[1] = new EducationLevel("college diploma");
        educationLevels[2] = new EducationLevel("bachelor's degree");
        educationLevels[3] = new EducationLevel("master's degree");
    }
    public static void display(){
        for (EducationLevel level:educationLevels) {
            System.out.println(level.toString());
        }
    }
}
