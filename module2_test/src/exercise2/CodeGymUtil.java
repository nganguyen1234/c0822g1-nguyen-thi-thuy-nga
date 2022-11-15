package exercise2;

public class CodeGymUtil {
    private final String REGEX = "C\\d{2}2\\dG\\d";

    public CodeGymUtil() {
    }

    public boolean isValidClassName(String name) throws InvalidFormatCGNameException {
        if (name.matches(REGEX)) {
            return true;
        }
       throw new InvalidFormatCGNameException("invalid format CodeGym name");
    }
}
