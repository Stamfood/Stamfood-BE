package kr.kro.stamfood.restaurant.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRestaurantRequestDto {
    @NotBlank(message = "음식점 이름을 입력해주세요.")
    @Size(max = 50, message = "음식점 이름은 최대 50자까지 입력 가능합니다.")
    private String resName;
    @NotBlank(message = "URL 을 입력해 주세요")
    private String resImage;
    @NotBlank(message = "주소를 입력해 주세요")
    private String resAddress;
    private String resMenuImage;
    @NotBlank(message = "양식인지 한식인지 일식인지 입력해주세요")
    private Long resType;
    private String resBestMenu;
    private String resDetail;


}
