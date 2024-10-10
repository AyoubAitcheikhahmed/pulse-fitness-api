package be.pulse.domain.discipline;

import lombok.Builder;

@Builder
public record CreateDisciplineRequest(String title, String  description, Long fee){}
