package be.pulse.adapter.dicipline.repository;

import be.pulse.domain.discipline.Discipline;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(schema = "DISCIPLINE")
@NoArgsConstructor
public class DisciplineJpaEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "TITLE",nullable = false)
    private String title;

    @Column(name = "DESCRIPTION",nullable = true)
    private String description;

    @Column(name = "FEE",nullable = false)
    private Long fee;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = true, updatable = false)
    private LocalDateTime createdDate;

    public DisciplineJpaEntity(String id, Discipline discipline) {
        this.id = id;
        this.title = discipline.getTitle();
        this.description = discipline.getDescription();
        this.fee = discipline.getFee();
        this.createdDate = LocalDateTime.now();
    }


}
