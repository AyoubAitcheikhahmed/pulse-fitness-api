package be.pulse.domain.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
    public static final DateValidator INSTANCE = new DateValidator();

    private DateValidator() {}

    public static void validate(LocalDate value, Notification notification) {
        if (value.isAfter(LocalDate.now())) {
            notification.addError("Date cannot be in the future.");
        }
        String dateString = value.toString();
        if (!isValidDateFormat(dateString)) {
            notification.addError("Invalid date format. Accepted formats: yyyy/MM/dd, dd/MM/yyyy, yyyy-MM-dd, dd-MM-yyyy.");
        }
    }

    private static boolean isValidDateFormat(String dateString) {
        String regex = "^(\\d{4}[/-]\\d{2}[/-]\\d{2}|\\d{2}[/-]\\d{2}[/-]\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);
        return matcher.matches();
    }
}
