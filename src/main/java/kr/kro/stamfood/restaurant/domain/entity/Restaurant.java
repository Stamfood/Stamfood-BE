package kr.kro.stamfood.restaurant.domain.entity;

import kr.kro.stamfood.Global.Domain.BaseEntity;
import kr.kro.stamfood.stamp.domain.entity.Stamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;
    @Column(name = "res_name")
    private String resName;
    @Column(name = "res_image")
    private String resImage;
    @Column(name = "res_address")
    private String resAddress;
    @Column(name = "res_menu_image")
    private String resMenuImage;
    @Column(name = "res_type")
    private String resType;
    @Column(name = "res_best_menu")
    private String resBestMenu;
    @Column(name = "res_detail")
    private String resDetail;
    @OneToMany(mappedBy = "restaurant")
    private List<Stamp> stamp = new ArrayList<>();
}
