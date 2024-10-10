package be.pulse.usecase.member.repository;

import be.pulse.domain.member.Member;
import be.pulse.domain.member.MemberProjection;
import be.pulse.domain.validator.Notification;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Notification create(Member member);
    Optional<MemberProjection> findById(String id);
    List<MemberProjection> findAll();

}
