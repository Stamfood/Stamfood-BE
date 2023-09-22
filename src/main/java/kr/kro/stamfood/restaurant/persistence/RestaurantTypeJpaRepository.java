package kr.kro.stamfood.restaurant.persistence;

import kr.kro.stamfood.restaurant.domain.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTypeJpaRepository extends JpaRepository<RestaurantType, Long> {
    boolean existsByResTypeId(Long resTypeId);

}
