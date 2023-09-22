//package kr.kro.stamfood.restaurant.unitTest.persistence;
//
//import kr.kro.stamfood.restaurant.domain.Restaurant;
//import kr.kro.stamfood.restaurant.persistence.RestaurantJpaRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@Profile("test")
//public class FakeRestaurantRepository implements RestaurantJpaRepository {
//    private final List<Restaurant> restaurants = new ArrayList<>();
//    private long idCounter = 1L;
//
//    @Override
//    public List<Restaurant> findAll() {
//        return restaurants;
//    }
//
//    @Override
//    public Optional<Restaurant> findById(Long id) {
//        return restaurants.stream()
//                .filter(restaurant -> restaurant.getRestaurantId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public <S extends Restaurant> S save(S entity) {
//        if (entity.getRestaurantId() == null) {
//            entity = entity.toBuilder()
//                    .restaurantId(idCounter++)
//                    .build();
//        }
//        restaurants.add(entity);
//        return entity;
//    }
//
//    @Override
//    public boolean existsByResName(String resName) {
//        return restaurants.stream()
//                .anyMatch(restaurant -> restaurant.getResName().equals(resName));
//    }
//}
