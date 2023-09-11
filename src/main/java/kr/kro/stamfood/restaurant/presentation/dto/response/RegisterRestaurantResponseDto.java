package kr.kro.stamfood.restaurant.presentation.dto.response;

import lombok.Data;

@Data
public class RegisterRestaurantResponseDto {
    private Long restaurantId;
    private String resName;
    private String resImage;
    private String resAddress;
    private String resMenuImage;
    private String resType;
    private String resBestMenu;
    private String resDetail;

}
