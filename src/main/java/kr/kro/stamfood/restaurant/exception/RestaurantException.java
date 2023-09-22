package kr.kro.stamfood.restaurant.exception;

public class RestaurantException extends RuntimeException {
    public RestaurantException(String message) {
        super(message);
    }

    public static RestaurantException restaurantAlreadyExists(String resName) {
        return new RestaurantException("해당 음식점 " + resName + "은 이미 등록되어 있습니다.");
    }

    public static RestaurantException restaurantNotFount(Long restaurantId) {
        return new RestaurantException(restaurantId + "은 존재하지 않습니다.");
    }

    public static RestaurantException typeNotFound(Long resTypeId) {
        return new RestaurantException(resTypeId + "은 존재하지 않습니다");
    }
}
