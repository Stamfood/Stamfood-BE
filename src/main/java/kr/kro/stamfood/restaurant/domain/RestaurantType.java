package kr.kro.stamfood.restaurant.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class RestaurantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resTypeId;
    @Column(name = "type_name", columnDefinition = "VARCHAR(10)")
    private String resType;
}
