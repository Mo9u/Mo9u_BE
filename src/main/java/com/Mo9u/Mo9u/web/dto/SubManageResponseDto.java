package com.Mo9u.Mo9u.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubManageResponseDto {
    private Long id;
    private Long subId;
    private String subName;
    private String subImage;
    private LocalDate creditDate;
    private int creditPrice;
}
