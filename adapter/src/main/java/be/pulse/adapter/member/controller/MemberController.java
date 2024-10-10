package be.pulse.adapter.member.controller;

import be.pulse.domain.member.CreateMemberRequest;
import be.pulse.domain.member.MemberProjection;
import be.pulse.usecase.member.usecase.CreateMemberUseCase;
import be.pulse.usecase.member.usecase.GetAllMembersUseCase;
import be.pulse.usecase.member.usecase.GetMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class MemberController implements MemberApi{

    private final CreateMemberUseCase createMemberUseCase;
    private final GetAllMembersUseCase getAllMembersUseCase;
    private final GetMemberUseCase getMemberUseCase;





    private MemberResponse mapToMemberResponseResource(MemberProjection member) {
        return MemberResponse.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .birthDate(member.getBirthDate())
                .phone(member.getPhone())
                .address(member.getAddress())
                .build();
    }

    @Override
    public ResponseEntity<Void> createMember(MemberRequest memberRequest) {
        var createMemberRequest = CreateMemberRequest.builder()
                .firstName(memberRequest.getFirstName())
                .lastName(memberRequest.getLastName())
                .birthday(memberRequest.getBirthDate())
                .email(memberRequest.getEmail())
                .phone(memberRequest.getPhone())
                .address(memberRequest.getAddress())
                .build();


        var notification = createMemberUseCase.execute(createMemberRequest);
        if (notification.hasErrors()) {
            System.out.println("IN THROW ================> ERROR:   " + notification.getErrors().toString());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, notification.errorMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



    @Override
    public ResponseEntity<MemberResponse> getMember(String id) {
        var member = getMemberUseCase.execute(id).map(this::mapToMemberResponseResource);
        member.ifPresentOrElse(memberResponse -> ResponseEntity.ok().body(memberResponse), () -> ResponseEntity.notFound().build());
        return ResponseEntity.status(HttpStatus.OK).build();
    }




    @Override
    public ResponseEntity<List<MemberResponse>> getMemberList() {
        var members = getAllMembersUseCase.execute();

        return ResponseEntity.ok(members.stream()
                .map(this::mapToMemberResponseResource)
                .collect(Collectors.toList()));
    }
}
