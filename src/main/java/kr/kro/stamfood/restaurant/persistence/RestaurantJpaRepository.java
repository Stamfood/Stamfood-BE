package kr.kro.stamfood.restaurant.persistence;

import kr.kro.stamfood.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByResName(String resName);
    Restaurant findByResName(String resName);


}
