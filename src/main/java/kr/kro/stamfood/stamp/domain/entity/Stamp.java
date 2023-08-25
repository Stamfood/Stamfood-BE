package kr.kro.stamfood.stamp.domain.entity;

import kr.kro.stamfood.Global.Domain.BaseEntity;
import kr.kro.stamfood.restaurant.domain.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Stamp extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stamp_id")
    private Long stampId;
    @Column(name = "stamp_type")
    private String stampType;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
}
