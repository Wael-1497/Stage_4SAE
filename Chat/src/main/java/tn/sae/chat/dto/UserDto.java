package tn.sae.chat.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NotBlank
    private String nickName;
    @NotBlank
    private String password;
}
