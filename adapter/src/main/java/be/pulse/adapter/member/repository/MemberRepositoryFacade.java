package be.pulse.adapter.member.repository;

import be.pulse.domain.member.Member;
import be.pulse.domain.member.MemberProjection;
import be.pulse.domain.validator.Notification;
import be.pulse.usecase.member.repository.MemberRepository;
import io.azam.ulidj.ULID;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberRepositoryFacade implements MemberRepository {

    private final MemberJpaRepository repository;

    public MemberRepositoryFacade(MemberJpaRepository repository) {
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
    public Optional<MemberProjection> findById(String id) {
        //Inferred type 'S' for type parameter 'S' is not within its bound; should extend 'be. pulse. adapter. member. repository. MemberJpaEntity'
//        return Optional.of(mapToMember(repository.findBy(id)));
        return repository.findById(id).map(this::mapToMemberProjection);
    }


    @Override
    public List<MemberProjection> findAll() {
        List<MemberJpaEntity> memberEntities = repository.findAll();
        return memberEntities.stream()
                .map(this::mapToMemberProjection)
                .collect(Collectors.toUnmodifiableList());
    }
    private Member mapToMember(MemberJpaEntity memberEntity) {
        return new Member(
                memberEntity.getFirstName(),
                memberEntity.getLastName(),
                memberEntity.getEmail(),
                memberEntity.getBirthday(),
                memberEntity.getPhone(),
                memberEntity.getAddress());
    }

    private MemberProjection mapToMemberProjection(MemberJpaEntity entity) {
        return MemberProjection.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .birthDate(entity.getBirthday()).build();
    }
}
