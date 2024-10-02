package be.pulse.domain.member;

import be.pulse.domain.member.validator.Creation;

public class MemberFactory {
    public Creation<Member> create(CreateMemberRequest request) {
        var member = new Member(request);
        return Creation.of(member,member.validate());
    }
}
