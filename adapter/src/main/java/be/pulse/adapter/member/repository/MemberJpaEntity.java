package be.pulse.adapter.member.repository;


import be.pulse.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "FIRST_NAME", nullable = false, unique = false, updatable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, unique = false, updatable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = false, updatable = false)
    private String email;

    @Column(name = "BIRTHDAY", nullable = false, unique = false, updatable = false)
    private LocalDate birthday;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = true, updatable = false)
    private LocalDateTime createdDate;
//  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");




    public MemberJpaEntity(String id, Member member) {
        this.id = id;
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.email = member.getEmail();
        this.birthday = member.getBirthDate();
        this.createdDate = LocalDateTime.now();
    }

}
