package be.pulse.domain.validator;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Creation<T extends Validatable> {

    private final T value;
    private final Notification notification;

    public static <T extends Validatable> Creation<T> of(T value, Notification notification) {
        //TODO: i dont understand why return a new one [new Creation<>]
        return new Creation<>(value, notification);
    }

    public static <T extends Validatable> Creation<T> of(Notification notification) {
        return new Creation<>(null, notification);
    }

    public T getValue() {
        if (notification.hasErrors()) {
            throw new IllegalStateException("Creation has errors");
        }
        return value;
    }

    public Notification getNotification() {
        return notification;
    }
}