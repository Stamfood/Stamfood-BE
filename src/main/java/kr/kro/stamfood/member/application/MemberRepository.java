package kr.kro.stamfood.member.application;

import kr.kro.stamfood.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {
    public Optional<Member> findById(long memberId);

    public Member save(Member member);

    public void delete(Member member);
}
