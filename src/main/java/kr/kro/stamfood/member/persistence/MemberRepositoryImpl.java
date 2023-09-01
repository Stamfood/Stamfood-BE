package kr.kro.stamfood.member.persistence;

import kr.kro.stamfood.member.application.MemberRepository;
import kr.kro.stamfood.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;

    public Optional<Member> findById(long memberId) {
        return memberJpaRepository.findById(memberId);
    }

    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }

    public void delete(Member member){
        memberJpaRepository.delete(member);
    }
}
