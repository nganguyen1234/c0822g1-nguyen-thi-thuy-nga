package common;

import com.sun.org.apache.regexp.internal.RE;

public class RegexCheck {
    private final String NAME_REGEX = "[A-Z]\\D+";
    private final String EMAIL_REGEX = "[a-zA-Z]\\w+@gmail\\.com";
    private final String PHONE_NUMBER_REGEX = "(090\\d{7})|(091\\d{7})|(\\(84\\)\\+90\\d{7})|(\\(84\\)\\+91\\d{7})";
    private final String ID_CARD_REGEX = "(\\d{9})|(\\d{11})";

    public boolean checkName(String name) {
        return name.matches(NAME_REGEX);
    }

    public boolean checkEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public boolean checkIdCard(String idCard) {
        return idCard.matches(ID_CARD_REGEX);
    }
}
