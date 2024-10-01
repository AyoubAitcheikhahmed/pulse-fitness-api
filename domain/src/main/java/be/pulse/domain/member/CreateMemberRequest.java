package be.pulse.domain.member;

import java.time.LocalDate;

public record CreateMemberRequest (String firstName, String lastName, String email, LocalDate birthday){}


