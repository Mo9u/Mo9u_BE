package com.Mo9u.Mo9u.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HttpResponseDto {

    private int code;
    private Object result;
}
