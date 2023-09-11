package kr.kro.stamfood.restaurant.presentation.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterTypeRequestDto {
    @NotBlank(message = "음식점 유형 이름을 입력해주세요.")
    private String resType;

}
