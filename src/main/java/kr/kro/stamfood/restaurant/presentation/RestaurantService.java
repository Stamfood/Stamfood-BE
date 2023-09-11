package kr.kro.stamfood.restaurant.presentation;

import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.response.RestaurantDetailResponseDto;

public interface RestaurantService {
    Long registerRestaurant(RegisterRestaurantRequestDto requestDto);
    RestaurantDetailResponseDto getRestaurantDetail(Long restaurantId);
    Long registerType(RegisterTypeRequestDto requestDto);
}
