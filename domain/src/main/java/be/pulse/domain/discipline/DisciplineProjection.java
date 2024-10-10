package be.pulse.domain.discipline;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DisciplineProjection {
    private String title;
    private String description;
    private Long fee;
}
