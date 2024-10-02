package be.pulse.domain.member.validator;


public class ObjectValidator {
    private ObjectValidator(){

    }

    public static void notNull(String field, Object value, Notification notification) {
        if (value == null) {
            notification.addError(String.format("Field '%s' should not be null", field));
        }
    }
}