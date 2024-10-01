package be.pulse.usecase.member.repository;

import be.pulse.domain.member.Member;

import java.util.Optional;

public interface MemberRepository {
    boolean create(Member member);

    Optional<Member> findById(String id);

}
