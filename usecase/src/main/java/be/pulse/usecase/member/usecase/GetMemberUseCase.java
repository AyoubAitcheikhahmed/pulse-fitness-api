package be.pulse.usecase.member.usecase;

import be.pulse.domain.member.Member;
import be.pulse.domain.member.MemberProjection;
import be.pulse.usecase.member.repository.MemberRepository;

import java.util.Optional;

public class GetMemberUseCase {
    private final MemberRepository memberRepository;

    public GetMemberUseCase(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<MemberProjection> execute(String id){ return memberRepository.findById(id);}
}
