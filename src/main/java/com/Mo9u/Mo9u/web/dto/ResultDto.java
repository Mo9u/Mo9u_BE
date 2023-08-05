package com.Mo9u.Mo9u.web.dto;

import com.Mo9u.Mo9u.domain.Subscribe;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResultDto {
    private Long Id;
    private String content;
    private String intro;
    private String name;
    private String resImage;

    @Builder
    public ResultDto(Long Id, String content, String intro, String name, String resImage){
        this.Id = Id;
        this.content = content;
        this.intro = intro;
        this.name = name;
        this.resImage = resImage;
    }
}
