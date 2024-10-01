package be.pulse.usecase.member.usecase;

import be.pulse.domain.member.Member;
import be.pulse.usecase.member.repository.MemberRepository;
import be.pulse.domain.member.CreateMemberRequest;

public class CreateMemberUseCase {
    MemberRepository repository;

    public CreateMemberUseCase(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean execute(CreateMemberRequest member) {
        return repository.create(new Member(member));
    }
}
