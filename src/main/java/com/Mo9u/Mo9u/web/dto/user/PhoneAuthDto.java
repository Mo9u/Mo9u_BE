package com.Mo9u.Mo9u.web.dto.user;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PhoneAuthDto {
    @NotBlank
    private String phoneNumber;
}
