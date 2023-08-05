package com.Mo9u.Mo9u.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class SubDetailResultDto {
    private int code;
    private Object result;
}
