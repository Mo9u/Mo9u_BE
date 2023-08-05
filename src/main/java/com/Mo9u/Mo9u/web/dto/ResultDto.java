package com.Mo9u.Mo9u.web.dto;

import com.Mo9u.Mo9u.domain.Subscribe;
import lombok.*;

@NoArgsConstructor
@Getter
public class ResultDto {
    private Long id;
    private String content;
    private String simpleContent;
    private String name;
    private String mainImage;

    @Builder
    public ResultDto(Long id, String content, String simpleContent, String name, String mainImage){
        this.id = id;
        this.content = content;
        this.simpleContent = simpleContent;
        this.name = name;
        this.mainImage = mainImage;
    }
}
