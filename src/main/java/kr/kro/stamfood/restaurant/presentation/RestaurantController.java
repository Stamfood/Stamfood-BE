package kr.kro.stamfood.restaurant.presentation;

import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.response.RegisterRestaurantResponseDto;
import kr.kro.stamfood.restaurant.presentation.dto.response.RestaurantDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
//    @PostMapping
//    public ResponseEntity<RegisterRestaurantResponseDto> registerRestaurant(@RequestBody RegisterRestaurantRequestDto requestDto) {
//        Long registeredRestaurantId = restaurantService.registerRestaurant(requestDto);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

//    @GetMapping("/{restaurantId}")
//    public ResponseEntity<?> detailRestaurant(@PathVariable Long restaurantId) {
////        try {
//            RestaurantDetailResponseDto responseDto = restaurantService.getRestaurantDetail(restaurantId);
//            return ResponseEntity.ok(responseDto);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류");
////        }
//    }

    @PostMapping("/register")
    public ResponseEntity<Long> registerRestaurant(@RequestBody RegisterTypeRequestDto requestDto) {
        Long registeredRestaurantId = restaurantService.registerType(requestDto);

        return new ResponseEntity<>(registeredRestaurantId, HttpStatus.CREATED);
    }
}
