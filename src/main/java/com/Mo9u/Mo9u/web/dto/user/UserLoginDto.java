package com.Mo9u.Mo9u.web.dto.user;

import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserLoginDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String loginPassword;
}
