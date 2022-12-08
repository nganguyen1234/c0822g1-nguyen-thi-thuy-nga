package common;

public class RegexCheck {

    public boolean checkName(String name) {
        final String NAME_REGEX = "[A-Z]\\D+";
        return name.matches(NAME_REGEX);
    }

}
