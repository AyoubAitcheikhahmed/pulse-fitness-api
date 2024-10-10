package be.pulse.domain.member;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateMemberRequest (String firstName, String lastName, String email, LocalDate birthday,String address, String phone){}


