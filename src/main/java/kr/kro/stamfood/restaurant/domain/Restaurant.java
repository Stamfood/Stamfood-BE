package kr.kro.stamfood.restaurant.domain;

import kr.kro.stamfood.Global.Domain.BaseEntity;
import kr.kro.stamfood.stamp.domain.Stamp;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", columnDefinition = "BIGINT")
    private Long restaurantId;
    @Column(name = "res_name", columnDefinition = "VARCHAR(10)")
    private String resName;
    @Column(name = "res_image", columnDefinition = "VARCHAR(20)")
    private String resImage;
    @Column(name = "res_address", columnDefinition = "VARCHAR(50)")
    private String resAddress;
    @Column(name = "res_menu_image", columnDefinition = "VARCHAR(20)")
    private String resMenuImage;
    @Column(name = "res_type", columnDefinition = "VARCHAR(10)")
    private String resType;
    @Column(name = "res_best_menu", columnDefinition = "VARCHAR(10)")
    private String resBestMenu;
    @Column(name = "res_detail", columnDefinition = "VARCHAR(10)")
    private String resDetail;
    @Column(name = "res_deleted", columnDefinition = "TINYINT(1) default 0")
    private int redDeleted;
    @OneToMany(mappedBy = "restaurant")
    private List<Stamp> stamp = new ArrayList<>();
}
