package com.Mo9u.Mo9u.web.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class SubListResponseDto {
    private Long id;
    private String category;
    private String mainImage;
    private String name;
    private String simpleContent;
}