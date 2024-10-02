package be.pulse.domain.member.validator;

public class IntegerValidator{

    public Notification validate(Integer value, Notification notification) {
        if (value == null) {
            notification.addError("Field value should not be null.");
            return notification; // Return early if value is null
        }
        if (value < 0) {
            notification.addError("Field value should not be negative.");
        }
        return notification;
    }

    public static void isBetweenInclusive(String field, int value, int min, int max, Notification notification) {
        if (value < min || value > max) {
            notification.addError(String.format("Field '%s' should be between %s and %s both inclusive", field, min, max));
        }
    }
}
