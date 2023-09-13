package kr.kro.stamfood.restaurant.unitTest.persistence;

import kr.kro.stamfood.restaurant.domain.Restaurant;
import kr.kro.stamfood.restaurant.domain.RestaurantType;
import kr.kro.stamfood.restaurant.persistence.RestaurantJpaRepository;
import kr.kro.stamfood.restaurant.persistence.RestaurantTypeJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
class RestaurantJpaRepositoryTest {

    @Autowired
    private RestaurantTypeJpaRepository restaurantTypeRepository;

    @Autowired
    private RestaurantJpaRepository restaurantRepository;
    @Test
    @DisplayName("음식점_타입_등록_테스트")
    @Transactional
    void 음식점_타입_등록() {
        // given
        RestaurantType restaurantType = RestaurantType.builder()
                .resType("한식")
                .build();

        //when
        RestaurantType saveType = restaurantTypeRepository.save(restaurantType);

        //then
        assertThat(restaurantType.getResType())
                .isEqualTo(saveType.getResType());
    }

    @Test
    @DisplayName("음식점_등록_테스트")
    @Transactional
    void 음식점_등록() {
        //given
        RestaurantType restaurantType = RestaurantType.builder()
                .resType("한식")
                .build();

        RestaurantType savedType = restaurantTypeRepository.save(restaurantType);
        assertThat(savedType).isNotNull();

        Restaurant restaurant = Restaurant.builder()
                .resName("새로운 음식점")
                .resImage("이미지 URL")
                .resAddress("주소")
                .resMenuImage("메뉴 이미지")
                .resType(savedType)
                .resBestMenu("대표 메뉴")
                .resDetail("디테일")
                .build();

        //when
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);

        //then
        assertThat(restaurant).isEqualTo(saveRestaurant);
     }
}
