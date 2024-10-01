package be.pulse.adapter.member.repository;

import be.pulse.domain.member.Member;
import be.pulse.usecase.member.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MemberService implements MemberRepository {

    private final MemberJpaRepository repository;

    public MemberService(MemberJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Member member) {
        MemberJpaEntity memberEntity = new MemberJpaEntity(UUID.randomUUID().toString(), member);
        var oSavedMember = repository.save(memberEntity);
        return oSavedMember != null;
    }

    @Override
    public Optional<Member> findById(String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
