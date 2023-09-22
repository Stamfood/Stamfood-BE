package kr.kro.stamfood.member.domain;

import kr.kro.stamfood.Global.Domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member")
@Builder
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_id")
    private Long memberId;

    @Column(name = "member_email",columnDefinition = "VARCHAR(30)", unique = true)
    private String memberEmail;

    @Column(name = "member_password", columnDefinition = "VARCHAR(40)")
    private String memeberPassword;

    @Column(name = "member_phone", columnDefinition = "VARCHAR(20)")
    private String memberPhone;

    @Column(name = "member_name", columnDefinition = "VARCHAR(10)")
    private String name;

    @Column(name = "member_role", columnDefinition = "VARCHAR(10)")
    @Enumerated(STRING)
    private MemberRole memberRole;

    @Builder.Default
    @Column(name = "member_status", columnDefinition = "VARCHAR(10) DEFAULT 'AVAILABLE'")
    @Enumerated(STRING)
    private MemberStatus memberStatus = MemberStatus.AVAILABLE;

}
