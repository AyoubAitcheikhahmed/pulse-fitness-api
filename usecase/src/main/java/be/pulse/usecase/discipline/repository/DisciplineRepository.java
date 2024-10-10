package be.pulse.usecase.discipline.repository;

import be.pulse.domain.discipline.Discipline;
import be.pulse.domain.discipline.DisciplineProjection;
import be.pulse.domain.validator.Notification;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository {
    Notification create(Discipline discipline);
    List<DisciplineProjection> findAll();
    Optional<DisciplineProjection> findById(String id);
}
