package be.pulse.domain.discipline;

import be.pulse.domain.validator.Notification;
import be.pulse.domain.validator.ObjectValidator;
import be.pulse.domain.validator.Validatable;
import lombok.Getter;

@Getter
public class Discipline implements Validatable {
    private String title;
    private String description;
    private Long fee;



    public Discipline(String title, String description, Long fee) {
        this.title = title;
        this.description = description;
        this.fee = fee;
    }

    public Discipline(CreateDisciplineRequest creatDiciplineRequest) {
        this.title = creatDiciplineRequest.title();
        this.description = creatDiciplineRequest.description();
        this.fee = creatDiciplineRequest.fee();
    }


    @Override
    public Notification validate() {
        var notofication = new Notification();
        ObjectValidator.notNull("title", title, notofication);
        ObjectValidator.notNull("fee", fee, notofication);

        return  notofication;
    }
}
