package be.pulse.usecase.member.repository;

import be.pulse.domain.member.Member;
import be.pulse.domain.member.validator.Notification;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Notification create(Member member);
    Optional<Member> findById(String id);
    List<Member> findAll();

}
