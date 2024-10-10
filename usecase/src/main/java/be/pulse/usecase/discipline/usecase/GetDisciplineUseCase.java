package be.pulse.usecase.discipline.usecase;

import be.pulse.domain.discipline.DisciplineProjection;
import be.pulse.usecase.discipline.repository.DisciplineRepository;
import java.util.Optional;

public class GetDisciplineUseCase {
    private DisciplineRepository disciplineRepository;

    public GetDisciplineUseCase(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public Optional<DisciplineProjection> getDicipline(String id) {
        return disciplineRepository.findById(id);
    }
}
