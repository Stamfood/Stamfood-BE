package kr.kro.stamfood.restaurant.unitTest.presentation;


import com.fasterxml.jackson.databind.ObjectMapper;
import kr.kro.stamfood.restaurant.presentation.RestaurantController;
import kr.kro.stamfood.restaurant.presentation.RestaurantService;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
@DisplayName("식당 컨트롤러 테스트")
class RestaurantControllerTest {
    @InjectMocks
    RestaurantController restaurantController;
    @Mock
    private RestaurantService restaurantService;
    MockMvc mvc;
    ObjectMapper objectMapper = new ObjectMapper();
    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }

    @Test
    @DisplayName("식당_타입_등록_테스트")
    void 식당_타입() throws Exception {
        // given
        RegisterTypeRequestDto requestDto = new RegisterTypeRequestDto("한식");

        // when, then
        mvc.perform(
                        post("/restaurants/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated());

        verify(restaurantService).registerType(requestDto);
    }

    @Test
    @DisplayName("식당_등록_테스트")
    void 식당_등록() throws Exception {
        //given
        RegisterTypeRequestDto typeRequestDto = new RegisterTypeRequestDto("한식");
        MvcResult typeResult = mvc.perform(
                        post("/restaurants/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(typeRequestDto)))
                .andExpect(status().isCreated())
                .andReturn();

        Long resTypeId = Long.parseLong(typeResult.getResponse().getContentAsString());

        RegisterRestaurantRequestDto requestDto = new RegisterRestaurantRequestDto("새로운식당", "해당URL", "주소",
                "메뉴이미지", resTypeId,"대표메뉴","상세");

        // when, then
        mvc.perform(
                        post("/restaurants")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated());

        verify(restaurantService).registerRestaurant(requestDto);

    }


}
