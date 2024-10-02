package be.pulse.domain.member;

import be.pulse.domain.member.validator.DateValidator;
import be.pulse.domain.member.validator.Notification;
import be.pulse.domain.member.validator.ObjectValidator;
import be.pulse.domain.member.validator.Validatable;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public final class Member implements Validatable {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public Member(CreateMemberRequest createMemberRequest) {
        this.firstName = createMemberRequest.firstName();
        this.lastName = createMemberRequest.lastName();
        this.birthDate = createMemberRequest.birthday();
        this.email = createMemberRequest.email();
    }

    public Member(String firstName, String lastName, LocalDate birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthday;
        this.email = email;
    }

    @Override
    public Notification validate() {
        var notification = new Notification();
        ObjectValidator.notNull("firstName" , firstName, notification);
        ObjectValidator.notNull("lastName" , lastName, notification);
        ObjectValidator.notNull("birthday" , birthDate, notification);
        ObjectValidator.notNull("email" , email, notification);
        DateValidator.validate(birthDate,notification);

        return notification;
    }
}



