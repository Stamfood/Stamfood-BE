package kr.kro.stamfood.restaurant.application;

import kr.kro.stamfood.restaurant.domain.Restaurant;
import kr.kro.stamfood.restaurant.domain.RestaurantType;
import kr.kro.stamfood.restaurant.exception.RestaurantException;
import kr.kro.stamfood.restaurant.persistence.RestaurantJpaRepository;
import kr.kro.stamfood.restaurant.persistence.RestaurantTypeJpaRepository;
import kr.kro.stamfood.restaurant.presentation.RestaurantService;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterRestaurantRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.request.RegisterTypeRequestDto;
import kr.kro.stamfood.restaurant.presentation.dto.response.RestaurantDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantJpaRepository restaurantRepository;
    private final RestaurantTypeJpaRepository typeJpaRepository;

    @Override
    @Transactional
    public Long registerRestaurant(RegisterRestaurantRequestDto requestDto) {

        // 등록된 음식점인지 확인
        if (restaurantRepository.existsByResName(requestDto.getResName())) {
            throw RestaurantException.restaurantAlreadyExists(requestDto.getResName());
        }
        Long resTypeId = requestDto.getResType();

        if (!typeJpaRepository.existsByResTypeId(resTypeId)) {
            throw RestaurantException.typeNotFound(resTypeId);
        }

        RestaurantType restaurantType = typeJpaRepository.findById(resTypeId).get();

        Restaurant restaurant = Restaurant.builder()
                .resName(requestDto.getResName())
                .resImage(requestDto.getResImage())
                .resAddress(requestDto.getResAddress())
                .resMenuImage(requestDto.getResMenuImage())
                .resType(restaurantType)
                .resBestMenu(requestDto.getResBestMenu())
                .resDetail(requestDto.getResDetail())
                .build();

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return savedRestaurant.getRestaurantId();
    }

    @Override
    @Transactional
    public RestaurantDetailResponseDto getRestaurantDetail(Long restaurantId) {

        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);

        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            return RestaurantDetailResponseDto.builder()
                    .restaurantId(restaurant.getRestaurantId())
                    .resName(restaurant.getResName())
                    .resImage(restaurant.getResImage())
                    .resAddress(restaurant.getResAddress())
                    .resMenuImage(restaurant.getResMenuImage())
                    .resType(restaurant.getResType())
                    .resBestMenu(restaurant.getResBestMenu())
                   .resDetail(restaurant.getResDetail())
                    .build();
        } else {
            // 해당 음식점이 없을 때
            throw RestaurantException.restaurantNotFount(restaurantId);
        }
    }

    @Override
    public Long registerType(RegisterTypeRequestDto requestDto) {

        RestaurantType restaurantType = RestaurantType.builder()
                .resType(requestDto.getResType())
                .build();

        RestaurantType savedType = typeJpaRepository.save(restaurantType);

        return savedType.getResTypeId();
    }
}
