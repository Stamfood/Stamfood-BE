package kr.kro.stamfood.member.persistence;

import kr.kro.stamfood.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
