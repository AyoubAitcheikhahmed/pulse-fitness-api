package be.pulse.adapter.dicipline.repository;

import be.pulse.domain.discipline.Discipline;
import be.pulse.domain.discipline.DisciplineProjection;
import be.pulse.domain.validator.Notification;
import be.pulse.usecase.discipline.repository.DisciplineRepository;
import io.azam.ulidj.ULID;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DisciplineRepositoryFacade implements DisciplineRepository {

    private final DisciplineJpaRepository repository;

    public DisciplineRepositoryFacade(DisciplineJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification create(Discipline discipline) {
        Notification notification = new Notification();

        try {
            repository.save(new DisciplineJpaEntity(ULID.random(),discipline));
        }catch (Exception e) {
            notification.addError(e.getMessage());
        }

        return notification;
    }

    @Override
    public List<DisciplineProjection> findAll() {
        return repository.findAll().stream()
                .map(this::mapToDisciplineProjection)
                .toList();
    }

    @Override
    public Optional<DisciplineProjection> findById(String id) {
        return repository.findById(id).map(this::mapToDisciplineProjection);
    }

    private DisciplineProjection mapToDisciplineProjection(DisciplineJpaEntity entity) {
        return DisciplineProjection.builder()
                .fee(entity.getFee())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }
}
