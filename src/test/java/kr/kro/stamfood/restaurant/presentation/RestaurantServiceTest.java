package kr.kro.stamfood.restaurant.presentation;

import kr.kro.stamfood.restaurant.domain.Restaurant;
import kr.kro.stamfood.restaurant.domain.RestaurantType;
import kr.kro.stamfood.restaurant.persistence.RestaurantJpaRepository;
import kr.kro.stamfood.restaurant.persistence.RestaurantTypeJpaRepository;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantJpaRepository restaurantRepository;

    @Autowired
    private RestaurantTypeJpaRepository restaurantTypeRepository;

    @Test
    @DisplayName("음식점 타입 등록 테스트")
    void 음식점_타입_등록() {
        //given
        RegisterTypeRequestDto requestDto = new RegisterTypeRequestDto();
        requestDto.setResType("한식");

        //when
        Long resTypeId = restaurantService.registerType(requestDto);

        //then
        assertThat(resTypeId).isNotNull();

        RestaurantType saveResType = restaurantTypeRepository.findById(resTypeId).orElse(null);
        assertThat(resTypeId).isNotNull();
        assertThat(saveResType.getResType()).isEqualTo(requestDto.getResType());
    }

    @Test
    @DisplayName("음식점 등록 테스트")
    void 음식점_등록() {
        // given
        RegisterTypeRequestDto typeRequestDto = new RegisterTypeRequestDto();
        typeRequestDto.setResType("한식");
        Long resTypeId = restaurantService.registerType(typeRequestDto);

        // when
        RegisterRestaurantRequestDto requestDto = new RegisterRestaurantRequestDto();
        requestDto.setResName("새로운음식점");
        requestDto.setResImage("이미지URL");
        requestDto.setResAddress("주소");
        requestDto.setResMenuImage("메뉴이미지URL");
        requestDto.setResType(resTypeId);
        requestDto.setResBestMenu("대표메뉴");
        requestDto.setResDetail("음식점 설명");

        Long restaurantId = restaurantService.registerRestaurant(requestDto);

        // then
        assertThat(restaurantId).isNotNull();

        // 음식점이 저장되었는지 확인
        Restaurant savedRestaurant = restaurantRepository.findById(restaurantId).orElse(null);
        assertThat(savedRestaurant).isNotNull();
        assertThat(savedRestaurant.getResName()).isEqualTo(requestDto.getResName());
        assertThat(savedRestaurant.getResImage()).isEqualTo(requestDto.getResImage());
        assertThat(savedRestaurant.getResAddress()).isEqualTo(requestDto.getResAddress());
        assertThat(savedRestaurant.getResMenuImage()).isEqualTo(requestDto.getResMenuImage());
        assertThat(savedRestaurant.getResBestMenu()).isEqualTo(requestDto.getResBestMenu());
        assertThat(savedRestaurant.getResDetail()).isEqualTo(requestDto.getResDetail());

        // 음식점 유형이 존재하는지 확인
        RestaurantType restaurantType = restaurantTypeRepository.findById(requestDto.getResType()).orElse(null);
        assertThat(restaurantType).isNotNull();
    }


}