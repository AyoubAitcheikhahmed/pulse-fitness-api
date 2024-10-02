package be.pulse.usecase.member.usecase;

import be.pulse.domain.member.Member;
import be.pulse.domain.member.MemberFactory;
import be.pulse.domain.member.validator.Creation;
import be.pulse.domain.member.validator.Notification;
import be.pulse.usecase.member.repository.MemberRepository;
import be.pulse.domain.member.CreateMemberRequest;

public class CreateMemberUseCase {

    private final MemberRepository repository;
    private final MemberFactory memberFactory;

    public CreateMemberUseCase(MemberRepository repository, MemberFactory memberFactory) {
        this.repository = repository;
        this.memberFactory = memberFactory;
    }

    public Notification execute(CreateMemberRequest request) {
        //FACTORY will return a Creation.of(member, Notification)
        final Creation<Member> appointmentCreation = memberFactory.create(request);

        if(appointmentCreation.getNotification().hasErrors()) return appointmentCreation.getNotification();

        /**As far as i know, The Get value acts here as a SAFE ACCESS TO THE value of T (Member in this case)
            allowing for:
                - Clear Separation of Concerns
                - Ensuring Validity
         */
        Member member = appointmentCreation.getValue();
        // At this point. Only GOD can judge you.
        return repository.create(member);
    }
}
