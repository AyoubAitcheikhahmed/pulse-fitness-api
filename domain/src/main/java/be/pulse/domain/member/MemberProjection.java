package be.pulse.domain.member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberProjection {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}

