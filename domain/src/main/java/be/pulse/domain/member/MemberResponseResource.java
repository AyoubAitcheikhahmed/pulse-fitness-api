package be.pulse.domain.member;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MemberResponseResource {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}