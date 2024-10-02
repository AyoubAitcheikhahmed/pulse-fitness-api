package be.pulse.adapter.member.controller;

import be.pulse.domain.member.CreateMemberRequest;
import be.pulse.domain.member.Member;
import be.pulse.domain.member.MemberResponseResource;
import be.pulse.usecase.member.usecase.CreateMemberUseCase;
import be.pulse.usecase.member.usecase.GetAllMembersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class MemberController implements MembersApi {

    private final CreateMemberUseCase createMemberUseCase;
    private final GetAllMembersUseCase getAllMembersUseCase;


    public ResponseEntity<List<MemberResponseResource>> getMembers() {
        var members = getAllMembersUseCase.execute();

        return ResponseEntity.ok(members.stream()
                .map(member -> mapToMemberResponseResource(member))
                .collect(Collectors.toList()));
    }

    public ResponseEntity<String> createMember(CreateMemberRequest requestResource) {
        var createMemberRequest = CreateMemberRequest.builder()
                .firstName(requestResource.firstName())
                .lastName(requestResource.lastName())
                .birthday(requestResource.birthday())
                .email(requestResource.email())
                .build();

        var notification = createMemberUseCase.execute(createMemberRequest);
        if (notification.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, notification.errorMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private MemberResponseResource mapToMemberResponseResource(Member member) {
        return MemberResponseResource.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .birthDate(member.getBirthDate())
                .build();
    }
}
