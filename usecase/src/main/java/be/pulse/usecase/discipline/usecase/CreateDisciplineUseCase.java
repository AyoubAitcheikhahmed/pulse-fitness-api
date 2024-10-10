package be.pulse.usecase.discipline.usecase;

import be.pulse.domain.discipline.CreateDisciplineRequest;
import be.pulse.domain.discipline.Discipline;
import be.pulse.domain.discipline.DisciplineFactory;
import be.pulse.domain.validator.Notification;
import be.pulse.usecase.discipline.repository.DisciplineRepository;

public class CreateDisciplineUseCase {

    private DisciplineRepository disciplineRepository;
    private DisciplineFactory disciplineFactory;

    public CreateDisciplineUseCase(DisciplineRepository disciplineRepository, DisciplineFactory disciplineFactory) {
        this.disciplineRepository = disciplineRepository;
        this.disciplineFactory = disciplineFactory;
    }

    public Notification execute(CreateDisciplineRequest request) {

        //using Factory we make the Creation that will validate and give us errors if needed
        var diciplineCreation = DisciplineFactory.creation(request);

        if(diciplineCreation.getNotification().hasErrors()){
            return diciplineCreation.getNotification();
        }

        Discipline discipline = diciplineCreation.getValue();
        return disciplineRepository.create(discipline);

    }
}
