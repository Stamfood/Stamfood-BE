package kr.kro.stamfood.stamp.domain;

import kr.kro.stamfood.Global.Domain.BaseEntity;
import kr.kro.stamfood.restaurant.domain.Restaurant;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Stamp extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stamp_id", columnDefinition = "BIGINT")
    private Long stampId;
    @Column(name = "stamp_type", columnDefinition = "VARCHAR(10)")
    private String stampType;
    @ManyToOne
    @JoinColumn(name = "restaurant_fk", columnDefinition = "BIGINT")
    private Restaurant restaurant;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
}
