package be.pulse.usecase.member.usecase;

import be.pulse.domain.member.Member;
import be.pulse.usecase.member.repository.MemberRepository;

import java.util.List;

public class GetAllMembersUseCase {
    private final MemberRepository memberRepository;

    public GetAllMembersUseCase(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> execute() {
        return  memberRepository.findAll();
    }
}
