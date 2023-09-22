package kr.kro.stamfood.restaurant.intergrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.kro.stamfood.restaurant.domain.Restaurant;
import kr.kro.stamfood.restaurant.persistence.RestaurantJpaRepository;
import kr.kro.stamfood.restaurant.persistence.RestaurantTypeJpaRepository;
import kr.kro.stamfood.restaurant.presentation.RestaurantController;
import kr.kro.stamfood.restaurant.presentation.RestaurantService;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
@AutoConfigureMockMvc
class RestaurantIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private RestaurantJpaRepository restaurantRepository;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new RestaurantController(restaurantService))
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    @DisplayName("음식점 등록 통합 테스트")
    void 음식점_등록_통합_테스트() throws Exception {
        // given
        RegisterTypeRequestDto requestDto = RegisterTypeRequestDto.builder()
                .resType("한식")
                .build();
        Long resTypeId = restaurantService.registerType(requestDto);

        RegisterRestaurantRequestDto restaurantRequestDto = RegisterRestaurantRequestDto.builder()
                .resName("새로운 음식점")
                .resImage("이미지 URL")
                .resAddress("주소")
                .resMenuImage("메뉴 이미지")
                .resType(resTypeId)
                .resBestMenu("대표 메뉴")
                .resDetail("디테일")
                .build();

        // when
        mockMvc.perform(post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restaurantRequestDto)))
                .andExpect(status().isCreated());

        // then
        Restaurant savedRestaurant = restaurantRepository.findByResName("새로운 음식점");
        assertThat(savedRestaurant).isNotNull();
        assertThat(savedRestaurant.getResName()).isEqualTo("새로운 음식점");
        assertThat(savedRestaurant.getResImage()).isEqualTo("이미지 URL");
        assertThat(savedRestaurant.getResAddress()).isEqualTo("주소");
        assertThat(savedRestaurant.getResMenuImage()).isEqualTo("메뉴 이미지");
        assertThat(savedRestaurant.getResType().getResTypeId()).isEqualTo(resTypeId);
        assertThat(savedRestaurant.getResBestMenu()).isEqualTo("대표 메뉴");
        assertThat(savedRestaurant.getResDetail()).isEqualTo("디테일");
    }



}
