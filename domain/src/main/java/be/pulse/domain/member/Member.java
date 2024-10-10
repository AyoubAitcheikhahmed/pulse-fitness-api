package be.pulse.domain.member;

import be.pulse.domain.validator.Notification;
import be.pulse.domain.validator.ObjectValidator;
import be.pulse.domain.validator.Validatable;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public final class  Member implements Validatable {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String address;

    public Member(CreateMemberRequest createMemberRequest) {
        this.firstName = createMemberRequest.firstName();
        this.lastName = createMemberRequest.lastName();
        this.birthDate = createMemberRequest.birthday();
        this.email = createMemberRequest.email();
        this.phone = createMemberRequest.phone();
        this.address = createMemberRequest.address();
    }

    public Member(String address, String phone, String email, LocalDate birthDate, String lastName, String firstName) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public Notification validate() {
        var notification = new Notification();
        ObjectValidator.notNull("firstName" , firstName, notification);
        ObjectValidator.notNull("lastName" , lastName, notification);
        ObjectValidator.notNull("birthday" , birthDate, notification);
        ObjectValidator.notNull("email" , email, notification);
        ObjectValidator.notNull("phone" , phone, notification);

        return notification;
    }
}



