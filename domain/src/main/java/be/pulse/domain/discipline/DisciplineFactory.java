package be.pulse.domain.discipline;

import be.pulse.domain.validator.Creation;

public class DisciplineFactory {
    public static Creation<Discipline> creation(CreateDisciplineRequest request) {
        var dicipline = new Discipline(request);
        return Creation.of(dicipline,dicipline.validate());
    }
}
