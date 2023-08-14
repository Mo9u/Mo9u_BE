package com.Mo9u.Mo9u.web.dto.user;

import com.Mo9u.Mo9u.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignUpDto {
    @NotBlank
    private String loginId;

    @NotBlank
    private String loginPassword;

    @NotBlank
    private String userName;

    @NotBlank
    private String userTel;

    private boolean reception;

    public User toEntity() {
        return User.builder()
                .loginId(loginId)
                .loginPassword(loginPassword)
                .userName(userName)
                .userTel(userTel)
                .reception(reception)
                .build();
    }
}
