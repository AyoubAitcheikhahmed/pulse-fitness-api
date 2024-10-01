package be.pulse.domain.member;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public final class Member {

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
}


