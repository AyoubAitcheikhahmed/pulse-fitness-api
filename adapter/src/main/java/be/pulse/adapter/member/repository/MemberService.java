package be.pulse.adapter.member.repository;

import be.pulse.domain.member.Member;
import be.pulse.domain.member.validator.Notification;
import be.pulse.usecase.member.repository.MemberRepository;
import io.azam.ulidj.ULID;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MemberService implements MemberRepository {

    private final MemberJpaRepository repository;

    public MemberService(MemberJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification create(Member member) {
        Notification notification = new Notification();
        try{
            repository.save(new MemberJpaEntity(ULID.random(),member));
            return Notification.ok();
        } catch (Exception e) {
            return Notification.of(e.getMessage());
        }
    }

    @Override
    public Optional<Member> findById(String id) {
        //Inferred type 'S' for type parameter 'S' is not within its bound; should extend 'be. pulse. adapter. member. repository. MemberJpaEntity'
//        return Optional.of(mapToMember(repository.findBy(id)));
        return repository.findById(id).map(this::mapToMember);
    }


    @Override
    public List<Member> findAll() {
        List<MemberJpaEntity> memberEntities = repository.findAll();
        return memberEntities.stream()
                .map(this::mapToMember)
                .collect(Collectors.toUnmodifiableList());
    }
    private Member mapToMember(MemberJpaEntity memberEntity) {
        return new Member(memberEntity.getFirstName(), memberEntity.getLastName(), memberEntity.getBirthday(), memberEntity.getEmail());
    }
}
