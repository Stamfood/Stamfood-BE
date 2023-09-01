package kr.kro.stamfood.member.persistence;

import kr.kro.stamfood.member.application.MemberRepository;
import kr.kro.stamfood.member.domain.Member;
import kr.kro.stamfood.member.domain.MemberRole;
import kr.kro.stamfood.member.domain.MemberStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Repository Null 확인")
    public void memberRepositoryNullCheck() {
        // given

        // when

        // then
        assertThat(memberRepository).isNotNull();
    }

    @Test
    @DisplayName("회원 추가 확인")
    @Transactional
    public void memberCreateCheck() {
        // given
        Member member = Member.builder()
                .name("회원")
                .memberEmail("test@test")
                .memberPhone("01012341234")
                .memberStatus(MemberStatus.AVAILABLE)
                .memberRole(MemberRole.USER)
                .memeberPassword("password")
                .build();

        // when
        Member saveMember = memberRepository.save(member);

        // then
        assertThat(saveMember)
                .hasFieldOrPropertyWithValue("memberEmail", member.getMemberEmail());
    }
}
