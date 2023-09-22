package kr.kro.stamfood.restaurant.presentation.dto.response;

import kr.kro.stamfood.restaurant.domain.RestaurantType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantDetailResponseDto {

    private Long restaurantId;
    private String resName;
    private String resImage;
    private String resAddress;
    private String resMenuImage;
    private RestaurantType resType;
    private String resBestMenu;
    private String resDetail;

}
