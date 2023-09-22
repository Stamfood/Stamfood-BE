package kr.kro.stamfood.restaurant.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTypeRequestDto {
    @NotBlank(message = "음식점 유형 이름을 입력해주세요.")
    private String resType;

}
