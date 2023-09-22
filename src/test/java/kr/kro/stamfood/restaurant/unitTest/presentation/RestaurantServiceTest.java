package kr.kro.stamfood.restaurant.unitTest.presentation;

import kr.kro.stamfood.restaurant.domain.Restaurant;
import kr.kro.stamfood.restaurant.domain.RestaurantType;
import kr.kro.stamfood.restaurant.persistence.RestaurantJpaRepository;
import kr.kro.stamfood.restaurant.persistence.RestaurantTypeJpaRepository;
import kr.kro.stamfood.restaurant.presentation.RestaurantService;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private RestaurantTypeJpaRepository restaurantTypeRepository;
    @Autowired
    private RestaurantJpaRepository restaurantRepository;

    @Test
    @DisplayName("음식점_타입_등록_테스트")
    @Transactional
    void 음식점_타입_등록() {
        // given
        RegisterTypeRequestDto typeRequestDto = RegisterTypeRequestDto.builder()
                .resType("한식")
                .build();

        // when
        Long resTypeId = restaurantService.registerType(typeRequestDto);

        // then
        assertThat(resTypeId).isNotNull();
        RestaurantType savedType = restaurantTypeRepository.findById(resTypeId).orElse(null);
        assertThat(savedType).isNotNull();
        assertThat(savedType.getResType()).isEqualTo(typeRequestDto.getResType());
    }


    @Test
    @DisplayName("음식점_등록_테스트")
    @Transactional
    void 음식점_등록() {
        // given
        RegisterTypeRequestDto requestDto = RegisterTypeRequestDto.builder()
                .resType("한식")
                .build();

        // when
        Long resTypeId = restaurantService.registerType(requestDto);
        assertThat(resTypeId).isNotNull();

        RegisterRestaurantRequestDto restaurantRequestDto = RegisterRestaurantRequestDto.builder()
                .resName("새로운 음식점")
                .resImage("이미지 URL")
                .resAddress("주소")
                .resMenuImage("메뉴 이미지")
                .resType(resTypeId)
                .resBestMenu("대표 메뉴")
                .resDetail("디테일")
                .build();

        Long restaurantId = restaurantService.registerRestaurant(restaurantRequestDto);

        // then
        assertThat(restaurantId).isNotNull();
        Restaurant savedRestaurant = restaurantRepository.findById(restaurantId).orElse(null);
        assertThat(savedRestaurant).isNotNull();
        assert savedRestaurant != null;
        assertThat(savedRestaurant.getResName()).isEqualTo(restaurantRequestDto.getResName());
        assertThat(savedRestaurant.getResImage()).isEqualTo(restaurantRequestDto.getResImage());
        assertThat(savedRestaurant.getResAddress()).isEqualTo(restaurantRequestDto.getResAddress());
        assertThat(savedRestaurant.getResMenuImage()).isEqualTo(restaurantRequestDto.getResMenuImage());
        assertThat(savedRestaurant.getResBestMenu()).isEqualTo(restaurantRequestDto.getResBestMenu());
        assertThat(savedRestaurant.getResDetail()).isEqualTo(restaurantRequestDto.getResDetail());
        assertThat(savedRestaurant.getResType().getResTypeId()).isEqualTo(resTypeId);
    }


}